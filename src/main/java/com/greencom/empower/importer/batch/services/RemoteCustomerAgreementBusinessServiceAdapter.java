package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("multi-master")
public class RemoteCustomerAgreementBusinessServiceAdapter implements BatchBusinessApiService<CustomerAgreement> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteCustomerAgreementBusinessServiceAdapter.class);

    @Value("${application.importService.host}")
    private String remoteHost;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void processItem(CustomerAgreement item) throws BatchFatalException, BatchRecoverableException {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(String.format("%s/import/customer-agreement", remoteHost), item, String.class);
            if (response.getStatusCode().isError()) {
                LOGGER.error("Received error {} from import service: {}", response.getStatusCode().value(), response.getBody());
            }

        } catch (RestClientException e) {
            throw new BatchRecoverableException(e);
        } catch (CustomerAgreementException e) {
            throw new BatchFatalException(e);
        }
    }
}
