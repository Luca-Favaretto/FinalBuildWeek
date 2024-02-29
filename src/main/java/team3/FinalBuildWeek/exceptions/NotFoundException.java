package team3.FinalBuildWeek.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Element with id " + id + " not found");
    }

    public NotFoundException(String name) {
        super("Element " + name + " not found");
    }
}
