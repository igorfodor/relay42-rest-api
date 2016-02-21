package com.relay42.web.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by teknik on 21-2-16.
 */


@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GeneralRestExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ TomatoBadRequestException.class, IllegalArgumentException.class })
    @ResponseBody
    public ErrorInfo handleBadRequestException(final Exception exception) {
        ErrorInfo info = new ErrorInfo(exception.getMessage());
        return info;
    }

}

class ErrorInfo {

    @JsonProperty("message")
    private String message;

    public ErrorInfo(String message) {
        this.message = message;
    }


}