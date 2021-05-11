package src.main.java.com.sword.trailersdb.exception;

public class ActorNotFoundException extends RuntimeException {
    ActorNotFoundException(Long id) {
        super("Could not find Actor " + id);
    }
}