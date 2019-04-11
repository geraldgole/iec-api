package com.greencom.empower.importer.model.exception;

public class CustomerAgreementException extends RuntimeException {

    public CustomerAgreementException() {
        this("CustomerAgreemet exception");
    }

    public CustomerAgreementException(String message) {
        this(message, null);
    }

    public CustomerAgreementException(String message, Throwable cause) {
        super(message, cause);
    }
}
