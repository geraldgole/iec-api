package com.greencom.empower.importer.batch.exceptions;

/**
 * Exception for batch single item processing "unrecoverable" failure which processing are to be skipped and logged.
 */
public class BatchFatalException extends Exception {

    public BatchFatalException() {}

    public BatchFatalException(String message) { super(message); }

    public BatchFatalException(String message, Throwable cause) { super(message, cause); }

    public BatchFatalException(Throwable cause) { super(cause); }
}
