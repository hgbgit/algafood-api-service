package com.algaworks.algafoodapi.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InUseEntityException extends RuntimeException {

    public InUseEntityException(String message) {
        super(message);
    }
}
