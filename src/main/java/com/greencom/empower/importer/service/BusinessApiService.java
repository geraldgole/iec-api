package com.greencom.empower.importer.service;

import com.greencom.empower.importer.model.exception.CustomerAgreementException;
import org.springframework.web.client.RestClientException;

public interface BusinessApiService<T> {

    void process(T item) throws RestClientException, CustomerAgreementException;
}
