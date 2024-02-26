package team3.FinalBuildWeek.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleBadRequest(BadRequestException ex) {
        if (ex.getErrorsList()!= null) {

            List<String> errorsList = ex.getErrorsList().stream().map(objectError -> objectError.getDefaultMessage()).toList();

            return new ErrorsPayloadWithList(ex.getMessage(), LocalDateTime.now(), errorsList);
        } else {
            return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
        }

    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFound(NotFoundException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorsPayload handleUnauthorized(UnauthorizedException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorsPayload handleIllegalArg(IllegalArgumentException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorsPayload handleAccessDenied(AccessDeniedException ex) {
        return new ErrorsPayload("Not authorized for this endpoint", LocalDateTime.now());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGenericErrors(Exception ex) {
        ex.printStackTrace();

        return new ErrorsPayload("Server-side issue, we'll fix it shortly! ", LocalDateTime.now());
    }
}
