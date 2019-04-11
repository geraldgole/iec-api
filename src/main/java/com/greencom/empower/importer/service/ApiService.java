package com.greencom.empower.importer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greencom.empower.importer.model.Device;
import com.greencom.empower.importer.model.Provider;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.customeragreement.UsagePoint;
import com.greencom.empower.importer.model.customeragreement.UsagePoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);

    @Value("${application.api.uri}")
    private String baseUri;

    @Value("${application.api.key")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    public boolean processCustomerAgreement(CustomerAgreement customerAgreement) throws IOException {


        Provider provider = getProvider(customerAgreement.getMRID());
        if (provider == null) {
            LOGGER.debug("Customer agreement {} does not exists", customerAgreement.getMRID());
            createCustomerAgreement(customerAgreement);
        } else {

        }


        return true;
    }


    private Provider getProvider(String id) throws IOException {

        ResponseEntity<Provider[]> providers = restTemplate.getForEntity(baseUri + "/providers?provider.type=customerAgreement&mrid={id}", Provider[].class, id);
        ObjectMapper objectMapper = new ObjectMapper();

        Provider[] body = providers.getBody();
        return body.length == 0 ? null : body[0];
    }

    private boolean createCustomerAgreement(CustomerAgreement customerAgreement) {

        Provider provider = new Provider(customerAgreement);

        UsagePoints usagePoints = customerAgreement.getUsagePoints();
        if (usagePoints != null) {
            for (UsagePoint usagePoint : usagePoints.getUsagePoint()) {
                Device device = new Device();
                device.setId(usagePoint.getMRID());
                device.addProperty("id", usagePoint.getMRID());
                device.addProperty("name", usagePoint.getName());
                provider.getDevices().add(device);
            }

        }

        restTemplate.postForLocation(baseUri + "/providers", provider);

        return true;
    }
}
