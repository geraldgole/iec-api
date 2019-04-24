package com.greencom.empower.importer.batch.writers;

import com.greencom.empower.importer.batch.services.BatchBusinessApiService;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerAgreementBatchItemWriter extends AbstractApiItemWriter<CustomerAgreement> {

    private static final Logger log = LoggerFactory.getLogger(CustomerAgreementBatchItemWriter.class);

    @Autowired
    private BatchBusinessApiService<CustomerAgreement> batchBusinessApiService;

    @Override
    public void write(List<? extends CustomerAgreement> list) throws Exception {
        log.info("{} items to process", list.size());

        for (CustomerAgreement provider : list) {
            batchBusinessApiService.processItem(provider);
        }
    }
}
