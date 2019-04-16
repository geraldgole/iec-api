package com.greencom.empower.importer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greencom.empower.importer.model.Provider;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerAgreementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAgreementService.class);

    @Value("${application.api.uri}")
    private String baseUri;

    @Autowired
    private RestTemplate restTemplate;


    public void processCustomerAgreement(CustomerAgreement customerAgreement) throws IOException {


        List<Provider> providers = getProviders(customerAgreement.getMRID());
        if (providers.size() == 0) {

            LOGGER.debug("Customer agreement {} does not exists", customerAgreement.getMRID());
            createCustomerAgreement(customerAgreement);

        } else {
            processExistingCustomerAgreement(customerAgreement, providers);
        }
    }


    private List<Provider> getProviders(String id) throws IOException {

        ResponseEntity<Provider[]> providers = restTemplate.getForEntity(baseUri + "/providers?provider.type=customerAgreement&mrid={id}", Provider[].class, id);
        ObjectMapper objectMapper = new ObjectMapper();

        Provider[] body = providers.getBody();
        return Arrays.asList(body);
    }

    private void createCustomerAgreement(CustomerAgreement customerAgreement) {

        Provider provider = new Provider(customerAgreement);

        try {
            restTemplate.postForLocation(baseUri + "/providers", provider);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }


    private void processExistingCustomerAgreement(CustomerAgreement customerAgreement, List<Provider> providers) {


        if (providers.stream().anyMatch(provider ->
                !StringUtils.equals(provider.getProperty("customer.id"), customerAgreement.getCustomer().getMRID()))) {
            throw new CustomerAgreementException(String.format("Customer agreement %s already assigned to a different customer", customerAgreement.getCustomer().getMRID()));
        }

        // Search provider from service id
        Optional<Provider> opt = providers.stream()
                .filter(provider -> StringUtils.equals(provider.getProperty("service.id"), customerAgreement.getServiceCategory().getMRID()))
                .findFirst();


        if (opt.isPresent()) {
            // update provider
            Provider provider = opt.get();
            provider.addProperty("validityInterval.end", customerAgreement.getValidityInterval().getEnd().toString());

            LOGGER.warn("Updating customer agreement {} validity interval end date to {}", customerAgreement.getMRID(), customerAgreement.getValidityInterval().getEnd().toString());
            restTemplate.put(String.format("%s/providers/%s", baseUri, provider.getId()), provider);
        } else {
            // new Service, so create new Provider
            LOGGER.warn("Creating new customer agreement for {} with service type {}", customerAgreement.getMRID(), customerAgreement.getServiceCategory().getName());
            createCustomerAgreement(customerAgreement);
        }
    }
}
