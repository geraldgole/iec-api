package com.greencom.empower.importer.model.exception;

public class CustomerAgreementException extends AbstractFunctionalValidationException {

    public CustomerAgreementException() {
        super();
    }

    public CustomerAgreementException(final String message) {
        super(message);
    }

    public CustomerAgreementException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
