package com.greencom.empower.importer.model.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Base class for exceptions representing a functional error processing a GreenCom entity e.g. the validation of an
 * incoming customer agreement.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public abstract class AbstractFunctionalValidationException extends Exception {

    public AbstractFunctionalValidationException() {
        super();
    }

    public AbstractFunctionalValidationException(final String message) {
        super(message);
    }

    public AbstractFunctionalValidationException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public AbstractFunctionalValidationException(final Throwable throwable) {
        super(throwable);
    }

}
