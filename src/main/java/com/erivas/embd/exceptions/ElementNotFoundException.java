package com.erivas.embd.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String object, Long id) {
        super("Could not find " + object + " id: " + id);
    }
}