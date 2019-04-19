package com.greencom.empower.importer.batch.writers;

import com.greencom.empower.importer.batch.services.CustomerAgreementBusinessServiceAdapter;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
@Qualifier("customerAgreementItemWriter")
public class CustomerAgreementBatchItemWriter extends AbstractApiItemWriter<CustomerAgreement> {

    private static final Logger log = LoggerFactory.getLogger(CustomerAgreementBatchItemWriter.class);

    public CustomerAgreementBatchItemWriter(@Autowired CustomerAgreementBusinessServiceAdapter customerAgreementBusinessServiceAdapter) {
        batchBusinessApiService = customerAgreementBusinessServiceAdapter;
    }

    @Override
    public void write(List<? extends CustomerAgreement> list) throws Exception {
        log.info("{} items to process", list.size());

        for (CustomerAgreement provider : list) {
            batchBusinessApiService.processItem(provider);
        }
    }
}