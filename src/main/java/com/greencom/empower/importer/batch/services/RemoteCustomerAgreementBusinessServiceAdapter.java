package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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
            HttpStatus status = response.getStatusCode();
        } catch (HttpClientErrorException e) {
            LOGGER.error(e.getResponseBodyAsString());
            throw new BatchFatalException(e.getResponseBodyAsString());
        } catch (HttpServerErrorException e) {
            LOGGER.error(e.getResponseBodyAsString());
            throw new BatchRecoverableException(e.getResponseBodyAsString());
        } catch (RestClientException e) {
            LOGGER.error("Failed to call worker: {}", e.getMessage());
            throw new BatchRecoverableException(e);
        }
    }
}
