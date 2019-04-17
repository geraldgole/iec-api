package com.greencom.empower.importer.batch;

import com.greencom.empower.importer.batch.services.BatchBusinessApiService;
import org.springframework.batch.item.ItemWriter;

public abstract class AbstractApiItemWriter<T> implements ItemWriter<T> {

    protected BatchBusinessApiService<T> batchBusinessApiService;
}
