package com.greencom.empower.importer.batch.exceptions;

/**
 * Exception for batch single item processing failure that can be recovered through retry.
 */
public class BatchRecoverableException extends Exception {

    public BatchRecoverableException() { super(); }

    public BatchRecoverableException(String message) { super(message); }

    public BatchRecoverableException(String message, Throwable cause) { super(message, cause); }

    public BatchRecoverableException(Throwable cause) { super(cause); }
}
