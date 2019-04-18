package com.greencom.empower.importer.batch.services;

import com.greencom.empower.importer.batch.exceptions.BatchFatalException;
import com.greencom.empower.importer.batch.exceptions.BatchRecoverableException;

/**
 * Service contract used to separate the exception's translation handling from the batch item output process.
 * @param <T> Type of the object to process.
 */
public interface BatchBusinessApiService<T> {

    void processItem(T item) throws BatchFatalException, BatchRecoverableException;
}
