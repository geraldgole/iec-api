package com.greencom.empower.importer.batch.writers;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.batch.services.CustomerAgreementBusinessServiceAdapter;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAgreementBatchItemWriterTest {

    @Mock
    private CustomerAgreementBusinessServiceAdapter customerAgreementBusinessServiceAdapter;

    @InjectMocks
    private CustomerAgreementBatchItemWriter customerAgreementBatchItemWriter;

    private List<CustomerAgreement> customerAgreementsListOf2Items;

    @Mock
    private CustomerAgreement customerAgreementMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerAgreementsListOf2Items = Arrays.asList(customerAgreementMock, customerAgreementMock);
    }

    @Test
    public void should_process_list_size_number_of_items() throws Exception {

        List<CustomerAgreement> customerAgreementsListOf100Items = new ArrayList<>();
        while(customerAgreementsListOf100Items.size() < 100) {
            customerAgreementsListOf100Items.add(customerAgreementMock);
        }

        doNothing().when(customerAgreementBusinessServiceAdapter).processItem(any(CustomerAgreement.class));

        customerAgreementBatchItemWriter.write(customerAgreementsListOf100Items);

        verify(customerAgreementBusinessServiceAdapter, times(customerAgreementsListOf100Items.size())).processItem(any(CustomerAgreement.class));
    }

    @Test(expected = BatchFatalException.class)
    public void should_throws_an_exception_when_receiving_BatchFatalException() throws Exception {
        doThrow(BatchFatalException.class).when(customerAgreementBusinessServiceAdapter).processItem(any(CustomerAgreement.class));
        customerAgreementBatchItemWriter.write(customerAgreementsListOf2Items);
    }

    @Test(expected = BatchRecoverableException.class)
    public void should_throws_an_exception_when_receiving_BatchRecoverableException() throws Exception {
        doThrow(BatchRecoverableException.class).when(customerAgreementBusinessServiceAdapter).processItem(any(CustomerAgreement.class));
        customerAgreementBatchItemWriter.write(customerAgreementsListOf2Items);
    }
}
