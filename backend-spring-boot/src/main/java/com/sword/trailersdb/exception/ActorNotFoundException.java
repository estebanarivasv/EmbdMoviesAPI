package com.sword.trailersdb.exception;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(Long id) {
        super("Could not find Actor " + id);
    }
}