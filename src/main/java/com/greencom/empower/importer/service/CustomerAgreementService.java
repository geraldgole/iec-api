package com.greencom.empower.importer.service;

import com.greencom.empower.importer.model.Device;
import com.greencom.empower.importer.model.Provider;
import com.greencom.empower.importer.model.ProviderType;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.customeragreement.UsagePoint;
import com.greencom.empower.importer.model.customeragreement.UsagePoints;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerAgreementService implements BusinessApiService<CustomerAgreement> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAgreementService.class);

    @Autowired
    private ApiService apiService;


    @Override
    public void process(CustomerAgreement customerAgreement) {

        List<Provider> providers = apiService.getProviders(ProviderType.CUSTOMER_AGREEMENT, Collections.singletonMap("mrid", customerAgreement.getMRID()));
        if (providers.size() == 0) {
            LOGGER.debug("Customer agreement {} does not exists", customerAgreement.getMRID());
            createCustomerAgreement(customerAgreement);

        } else {
            processExistingCustomerAgreement(customerAgreement, providers);
        }
    }

    private void createCustomerAgreement(CustomerAgreement customerAgreement) {

        UsagePoints ups = customerAgreement.getUsagePoints();
        if (ups != null) {
            for (UsagePoint up : ups.getUsagePoint()) {
                List<Device> devices = apiService.getDevices(Collections.singletonMap("usagePoint.id", up.getMRID()));
                for (Device device : devices) {
                    Provider provider = apiService.getProvider(device.getProviderId());
                    Instant start = Instant.parse(provider.getProperty("validityInterval.start"));
                    Instant end = Instant.parse(provider.getProperty("validityInterval.end"));
                    Instant now = Instant.now();
                    if (now.isAfter(start) && now.isBefore(end)) {
                        throw new CustomerAgreementException(String.format("An already active customer agreement (%s) exists for this usage point (%s)", provider.getId(), device.getId()));
                    }
                }
            }
        }

        Provider provider = new Provider(customerAgreement);
        apiService.createProvider(provider);
    }


    private void processExistingCustomerAgreement(CustomerAgreement customerAgreement, List<Provider> providers) {

        // Providers should contain ONLY ONE provider according to O. Brie

        // Check if CA is assigned to a different customer
        if (providers.stream().anyMatch(provider ->
                !StringUtils.equals(provider.getProperty("customer.id"), customerAgreement.getCustomer().getMRID()))) {
            throw new CustomerAgreementException(String.format("Customer agreement %s already assigned to a different customer {}", customerAgreement.getMRID(), customerAgreement.getCustomer().getMRID()));
        }

        // Search provider from service id
        Optional<Provider> opt = providers.stream()
                .filter(provider -> StringUtils.equals(provider.getProperty("service.id"), customerAgreement.getServiceCategory().getMRID()))
                .findFirst();

        // Check if service is the same between Provider and CustomerAgreement
        if (opt.isPresent()) {
            // update provider
            Provider provider = opt.get();

            // Check if UsagePoints sets are identical
            if (customerAgreement.getUsagePoints().getUsagePoint().size() != provider.getDevices().size()) {
                LOGGER.error("Customer agreement {} has different usage points assigned", customerAgreement.getMRID());
                throw new CustomerAgreementException(String.format("Customer agreement {} has different usage points assigned", customerAgreement.getMRID()));
            }

            // Compare each Usage Point with each device in provider
            for (UsagePoint up : customerAgreement.getUsagePoints().getUsagePoint()) {
                if (provider.getDevices().stream().noneMatch(device -> device.getId().equals(up.getMRID()))) {
                    LOGGER.error("Customer agreement {} already assigned to different usage point {}", customerAgreement.getMRID(), up.getMRID());
                    throw new CustomerAgreementException(String.format("Customer agreement %s already assigned to a different usage point", customerAgreement.getMRID(), up.getMRID()));
                }
            }

            LOGGER.debug("Updating customer agreement {} validity interval end date to {}", customerAgreement.getMRID(), customerAgreement.getValidityInterval().getEnd().toString());
            provider.addProperty("validityInterval.end", customerAgreement.getValidityInterval().getEnd().toString());
            apiService.updateProvider(provider.getId(), provider);

        } else {
            // new Service, so create new Provider
            LOGGER.error("Customer agreement {} already assigned to different service {}", customerAgreement.getMRID(), customerAgreement.getServiceCategory().getName());
            throw new CustomerAgreementException(String.format("Customer agreement %s already assigned to a different service", customerAgreement.getMRID(), customerAgreement.getServiceCategory().getMRID()));
        }
    }
}
