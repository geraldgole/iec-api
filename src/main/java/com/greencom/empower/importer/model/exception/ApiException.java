package com.greencom.empower.importer.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ApiException extends RuntimeException {

    private HttpStatus httpStatus;

    public ApiException(final String message) {
        super(message);
    }

    public ApiException(final String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
