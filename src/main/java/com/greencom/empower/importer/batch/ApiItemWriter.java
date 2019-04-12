package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.service.ApiService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ApiItemWriter<T> implements ItemWriter<T> {

    @Autowired
    protected ApiService apiService;
}
