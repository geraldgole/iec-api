package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.batch.processors.CustomerAgreementToProviderProcessor;
import com.greencom.empower.importer.model.Provider;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreements;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
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
                                            CustomerAgreementToProviderProcessor customerAgreementToProviderProcessor,
                                            ItemWriter<Provider> customerAgreementItemWriter) {
        return stepBuilderFactory.get("validation_step")
                .<CustomerAgreement, Provider>chunk(100)
                .reader(customerAgreementItemReader)
                .processor(customerAgreementToProviderProcessor)
                .writer(customerAgreementItemWriter)
                .build();
    }

    @Bean
    public StaxEventItemReader<CustomerAgreement> customerAgreementItemReader() {
        return new StaxEventItemReaderBuilder<CustomerAgreement>()
                .name("customer_agreements_item_reader")
                .resource(new ClassPathResource("customer_agreement.xml"))
                .addFragmentRootElements("CustomerAgreement")
                .unmarshaller(customerAgreementUnmarshaller())
                .strict(false)
                .build();
    }

    @Bean
    public Unmarshaller customerAgreementUnmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setClassesToBeBound(CustomerAgreement.class, CustomerAgreements.class);
        unmarshaller.setCheckForXmlRootElement(false);
        return unmarshaller;
    }

    @Bean
    public CustomerAgreementToProviderProcessor customerAgreementToProviderProcessor() {
        return new CustomerAgreementToProviderProcessor();
    }

    @Bean
    public ApiItemWriter<Provider> customerAgreementItemWriter() {
        return new ProviderBatchItemWriter();
    }
}
