package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProviderBatchItemWriter extends ApiItemWriter<CustomerAgreement> {

    private static final Logger log = LoggerFactory.getLogger(ProviderBatchItemWriter.class);

    @Override
    public void write(List<? extends CustomerAgreement> list) throws Exception {
        log.info("Processed {} items", list.size());
    }
}
