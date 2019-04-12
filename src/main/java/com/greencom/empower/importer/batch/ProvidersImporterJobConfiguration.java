package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
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
                                            ItemWriter<CustomerAgreement> customerAgreementItemWriter) {
        return stepBuilderFactory.get("validation_step")
                .<CustomerAgreement, CustomerAgreement>chunk(100)
                .reader(customerAgreementItemReader)
                .writer(customerAgreementItemWriter)
                .build();
    }

    @Bean
    public StaxEventItemReader<CustomerAgreement> customerAgreementItemReader(Unmarshaller customerAgreementFileUnmarshaller) {
        return new StaxEventItemReaderBuilder<CustomerAgreement>()
                .name("customer_agreements_item_reader")
                .resource(new ClassPathResource("customer_agreements.xml"))
                .addFragmentRootElements("CustomerAgreement")
                .unmarshaller(customerAgreementFileUnmarshaller)
                .build();
    }

    @Bean
    public Unmarshaller customerAgreementFileUnmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setClassesToBeBound(CustomerAgreement.class);
        unmarshaller.setCheckForXmlRootElement(false);
        return unmarshaller;
    }

    @Bean
    public ApiItemWriter<CustomerAgreement> customerAgreementItemWriter() {
        return new ProviderBatchItemWriter();
    }
}
