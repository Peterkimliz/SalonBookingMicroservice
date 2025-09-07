package com.example.barbsalon.exceptions;

public class ItemExistsException extends RuntimeException {
    public ItemExistsException(String message) {
        super(message);
    }
}
