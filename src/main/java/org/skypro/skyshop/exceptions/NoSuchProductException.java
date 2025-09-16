package org.skypro.skyshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchProductException extends RuntimeException {
    UUID id;
    public NoSuchProductException(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
