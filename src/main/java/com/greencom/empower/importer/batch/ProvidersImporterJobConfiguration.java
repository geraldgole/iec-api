package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;
import com.greencom.empower.importer.batch.listeners.RetryLoggerListener;
import com.greencom.empower.importer.batch.listeners.SkipLoggerListener;
import com.greencom.empower.importer.batch.processors.CustomerAgreementToProviderProcessor;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;

@Configuration
@EnableBatchProcessing
public class ProvidersImporterJobConfiguration {

    private static final String[] REQUIRED_JOB_PARAMETERS = {"file", "execution_time"};
    private static final String[] OPTIONAL_JOB_PARAMETERS = {};

    private static final long INITIAL_BACK_OFF_INTERVAL = 10000;
    private static final long MAX_BACK_OFF_INTERVAL = 50000;

    private static final int RETRY_LIMIT = 3;
    // TODO : Define a skip limit for a batch's chunck or override the default SkipPolicy for unrestrained skipping.
    private static final int SKIP_LIMIT = 100;


    @Value("classpath:schemas/CustomerAgreements.xsd")
    private Resource customerAgreementsSchema;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job providerImporterJob(Step customerAgreementProcessing) {
        return jobBuilderFactory.get("providers_importer")
                .validator(new DefaultJobParametersValidator(REQUIRED_JOB_PARAMETERS, OPTIONAL_JOB_PARAMETERS))
                .flow(customerAgreementProcessing)
                .end()
                .build();
    }

    @Bean
    public Step customerAgreementProcessing(ItemReader<CustomerAgreement> customerAgreementItemReader,
                                            ItemWriter<CustomerAgreement> customerAgreementItemWriter) {
        return stepBuilderFactory.get("validation_step")
                .<CustomerAgreement, CustomerAgreement>chunk(100)
                .reader(customerAgreementItemReader)
                .writer(customerAgreementItemWriter)
                .faultTolerant()
                .noRollback(BatchRecoverableException.class)
                .retry(BatchRecoverableException.class)
                .retryPolicy(new SimpleRetryPolicy())
                .retryLimit(this.RETRY_LIMIT)
                .backOffPolicy(backOffPolicy())
                .skip(BatchRecoverableException.class)
                .skipLimit(SKIP_LIMIT)
                .listener(new RetryLoggerListener())
                .listener(new SkipLoggerListener())
                .build();
    }

    @Bean
    @StepScope
    public StaxEventItemReader<CustomerAgreement> customerAgreementItemReader(@Value("#{jobParameters['file']}") String filePath) {
        return new StaxEventItemReaderBuilder<CustomerAgreement>()
                .name("customer_agreements_item_reader")
                .resource(new FileSystemResource(filePath))
                .addFragmentRootElements("CustomerAgreement")
                .unmarshaller(customerAgreementUnmarshaller())
                .strict(true)
                .build();
    }

    @Bean
    public Unmarshaller customerAgreementUnmarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setMappedClass(CustomerAgreement.class);
        jaxb2Marshaller.setClassesToBeBound(CustomerAgreement.class);
        jaxb2Marshaller.setSchema(this.customerAgreementsSchema);
        return jaxb2Marshaller;
    }

    // TODO : remove if no item processor is used during the validation_step
    @Bean
    public CustomerAgreementToProviderProcessor customerAgreementToProviderProcessor() {
        return new CustomerAgreementToProviderProcessor();
    }

    @Bean
    public BackOffPolicy backOffPolicy() {
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(INITIAL_BACK_OFF_INTERVAL);
        backOffPolicy.setMaxInterval(MAX_BACK_OFF_INTERVAL);
        return backOffPolicy;
    }
}
