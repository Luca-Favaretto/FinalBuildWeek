package team3.FinalBuildWeek.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorsPayloadWithList extends ErrorsPayload {
    private List<String> errorsList;

    public ErrorsPayloadWithList(String message, LocalDateTime timestamp, List<String> errorsList) {
        super(message, timestamp);
        this.errorsList = errorsList;
    }
}
