package team3.FinalBuildWeek.exceptions;

public class FullException extends RuntimeException {
    public FullException() {
        super("The event is already full!");
    }
}
