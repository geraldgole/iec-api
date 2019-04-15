package com.greencom.empower.importer.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
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
