package com.example.barbsalon.exceptions;

public class ItemNotFound extends RuntimeException{
    public ItemNotFound(String message) {
        super(message);
    }
}
