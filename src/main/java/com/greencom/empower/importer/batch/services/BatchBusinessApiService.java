package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;

public interface BatchBusinessApiService<T> {

    void processItem(T item) throws BatchFatalException, BatchRecoverableException;
}
