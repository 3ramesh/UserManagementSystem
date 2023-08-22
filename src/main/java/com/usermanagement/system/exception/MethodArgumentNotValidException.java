package com.usermanagement.system.exception;

import lombok.Getter;

import static com.usermanagement.system.utils.ExceptionUtils.getLocalDateTime;
import static com.usermanagement.system.utils.ValidationUtils.getExceptionForMethodArgumentNotValid;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Getter
public class MethodArgumentNotValidException extends RuntimeException {

    public static ExceptionResponse handleMethodArgumentNotValidException(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        String errorMessage = getExceptionForMethodArgumentNotValid(ex);

        return ExceptionResponse.builder()
                .errorMessage(errorMessage)
                .debugMessage(errorMessage)
                .responseStatus(BAD_REQUEST)
                .responseCode(BAD_REQUEST.value())
                .timeStamp(getLocalDateTime())
                .build();
    }
}
