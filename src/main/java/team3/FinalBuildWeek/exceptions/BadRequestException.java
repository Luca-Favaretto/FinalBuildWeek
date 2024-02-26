package team3.FinalBuildWeek.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
    private List<ObjectError> errorsList;

    public BadRequestException(String message) {
        super("Error caused by: " + message);
    }

    public BadRequestException(List<ObjectError> errorsList) {
        super("Error in payload");
        this.errorsList = errorsList;
    }
}
