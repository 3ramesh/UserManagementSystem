package com.usermanagement.system.exception;

import com.usermanagement.system.utils.ExceptionUtils;
import lombok.Getter;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Getter
public class ConstraintViolationException extends RuntimeException{

    private ExceptionResponse exception;

    public ConstraintViolationException(String errorMessage, String debugMessage) {
        super(errorMessage);
        setErrorResponse(errorMessage, debugMessage);
    }

    private void setErrorResponse(String errorMessage, String debugMessage) {

        exception = ExceptionResponse.builder()
                .errorMessage(errorMessage)
                .debugMessage(debugMessage)
                .responseStatus(BAD_REQUEST)
                .responseCode(BAD_REQUEST.value())
                .timeStamp(ExceptionUtils.getLocalDateTime())
                .build();
    }


}
