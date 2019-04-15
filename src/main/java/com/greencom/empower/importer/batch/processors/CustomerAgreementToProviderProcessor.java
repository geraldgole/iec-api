package com.greencom.empower.importer.batch.processors;

import com.greencom.empower.importer.model.Provider;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.springframework.batch.item.ItemProcessor;

/**
 * Simple processor to convert CustomerAgreement into Provider
 */
public class CustomerAgreementToProviderProcessor implements ItemProcessor<CustomerAgreement, Provider> {

    @Override
    public Provider process(final CustomerAgreement customerAgreement) throws Exception {
        return new Provider(customerAgreement);
    }
}
