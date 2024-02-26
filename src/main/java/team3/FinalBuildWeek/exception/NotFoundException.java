package team3.FinalBuildWeek.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Element with id " + id + " not found");
    }

    public NotFoundException(String email) {
        super("Element with mail " + email + " not found");
    }
}
