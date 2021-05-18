package com.sword.trailersdb.exceptions;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(Long id) {
        super("Could not find Actor " + id);
    }
}