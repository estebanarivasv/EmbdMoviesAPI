package com.sword.trailersdb.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(Long id) {
        super("Could not find element." + id);
    }
}