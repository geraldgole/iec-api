package com.greencom.empower.importer.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ServerApiException extends ApiException {

    public ServerApiException(final String message) {
        super(message);
    }

    public ServerApiException(final String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
