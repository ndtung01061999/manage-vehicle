package vn.com.devmaster.services.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BadAlertRequestException.class)
    public ProblemDetail handleBadRequestException(BadAlertRequestException ex) {
        ProblemDetail proEx = new ProblemDetail();
        proEx.setMessage(ex.getMsg());
        proEx.setEntity(ex.getEntity());
        proEx.setCode(ex.getCode());
        proEx.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return proEx;
    }
}
