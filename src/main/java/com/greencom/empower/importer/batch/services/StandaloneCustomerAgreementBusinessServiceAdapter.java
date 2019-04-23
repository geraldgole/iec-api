package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import com.greencom.empower.importer.service.BusinessApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
@Qualifier("customerAgreementBusinessServiceAdapter")
@Profile("standalone")
public class StandaloneCustomerAgreementBusinessServiceAdapter implements BatchBusinessApiService<CustomerAgreement> {

    @Autowired
    protected BusinessApiService<CustomerAgreement> businessApiService;

    @Override
    public void processItem(CustomerAgreement item) throws BatchFatalException, BatchRecoverableException {
        try {
            businessApiService.process(item);
        } catch (RestClientException e) {
            throw new BatchRecoverableException(e);
        } catch (CustomerAgreementException e) {
            throw new BatchFatalException(e);
        }
    }
}
