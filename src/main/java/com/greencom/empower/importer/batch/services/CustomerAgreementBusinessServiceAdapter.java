package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import com.greencom.empower.importer.service.BusinessApiService;
import com.greencom.empower.importer.service.CustomerAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
@Qualifier("customerAgreementBusinessServiceAdapter")
public class CustomerAgreementBusinessServiceAdapter implements BatchBusinessApiService<CustomerAgreement> {

    protected BusinessApiService<CustomerAgreement> businessApiService;

    public CustomerAgreementBusinessServiceAdapter(@Autowired CustomerAgreementService customerAgreementService) {
        this.businessApiService = customerAgreementService;
    }

    @Override
    public void processItem(CustomerAgreement item) throws BatchFatalException, BatchRecoverableException {
        try {
            this.businessApiService.process(item);
        } catch (RestClientException e) {
            throw new BatchRecoverableException(e);
        } catch (CustomerAgreementException e) {
            throw new BatchFatalException(e);
        }
    }
}
