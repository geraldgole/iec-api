package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.batch.processors.CustomerAgreementToProviderProcessor;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableBatchProcessing
public class ProvidersImporterJobConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job providerImporterJob(Step customerAgreementProcessing) {
        return jobBuilderFactory.get("providers_importer")
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
                .strict(false)
                .build();
    }

    @Bean
    public Unmarshaller customerAgreementUnmarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setMappedClass(CustomerAgreement.class);
        jaxb2Marshaller.setClassesToBeBound(CustomerAgreement.class);
        return jaxb2Marshaller;
    }

    // TODO : remove if no item processor is used during the validation_step
    @Bean
    public CustomerAgreementToProviderProcessor customerAgreementToProviderProcessor() {
        return new CustomerAgreementToProviderProcessor();
    }

    @Bean
    public ApiItemWriter<CustomerAgreement> customerAgreementItemWriter() {
        return new CustomerAgreementBatchItemWriter();
    }
}
