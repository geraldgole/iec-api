package com.greencom.empower.importer.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ClientApiException extends ApiException {

    public ClientApiException(final String message) {
        super(message);
    }

    public ClientApiException(final String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
