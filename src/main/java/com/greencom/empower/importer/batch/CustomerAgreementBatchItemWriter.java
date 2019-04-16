package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerAgreementBatchItemWriter extends ApiItemWriter<CustomerAgreement> {

    private static final Logger log = LoggerFactory.getLogger(CustomerAgreementBatchItemWriter.class);

    @Override
    public void write(List<? extends CustomerAgreement> list) throws Exception {
        log.info("{} items to process", list.size());

        for (CustomerAgreement provider : list) {
            apiService.processCustomerAgreement(provider);
        }
    }
}
