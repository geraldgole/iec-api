package com.greencom.empower.importer.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAgreementException extends RuntimeException {

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
