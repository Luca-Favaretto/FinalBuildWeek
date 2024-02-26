package team3.FinalBuildWeek.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Element with id " + id + " not found");
    }

    public NotFoundException(String email) {
        super("Element with mail " + email + " not found");
    }
}
