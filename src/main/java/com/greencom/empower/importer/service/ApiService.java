package com.greencom.empower.importer.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);

    @Value("${application.api.uri}")
    private String baseUri;

    @Value("${application.api.key")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    public boolean processCustomerAgreement(CustomerAgreement customerAgreement) {

        JsonNode provider = restTemplate.getForObject(baseUri + "/providers?provider.type=customerAgreement&mRID={id}", JsonNode.class, customerAgreement.getMRID());
        LOGGER.warn("{}", provider);
        return true;
    }


    private JsonNode getProvider(String id) {

        JsonNode provider = restTemplate.getForObject(baseUri + "/providers?provider.type=customerAgreement&mRID={id}", JsonNode.class, id);
        return provider;
    }
}
