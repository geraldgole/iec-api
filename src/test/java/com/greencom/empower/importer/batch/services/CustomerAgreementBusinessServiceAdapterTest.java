package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import com.greencom.empower.importer.service.CustomerAgreementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAgreementBusinessServiceAdapterTest {

    @Mock
    private CustomerAgreementService customerAgreementService;

    @InjectMocks
    private StandaloneCustomerAgreementBusinessServiceAdapter customerAgreementBusinessServiceAdapter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = BatchFatalException.class)
    public void should_translate_exceptions_into_batch_fatal_exception()
            throws BatchRecoverableException,
            BatchFatalException,
            CustomerAgreementException {

        doThrow(CustomerAgreementException.class).when(customerAgreementService).process((any(CustomerAgreement.class)));
        customerAgreementBusinessServiceAdapter.processItem(new CustomerAgreement());
    }

    @Test(expected = BatchRecoverableException.class)
    public void should_translate_exceptions_into_batch_recoverable_exception()
            throws BatchRecoverableException,
            BatchFatalException,
            CustomerAgreementException {

        doThrow(RestClientException.class).when(customerAgreementService).process((any(CustomerAgreement.class)));
        customerAgreementBusinessServiceAdapter.processItem(new CustomerAgreement());
    }
}
