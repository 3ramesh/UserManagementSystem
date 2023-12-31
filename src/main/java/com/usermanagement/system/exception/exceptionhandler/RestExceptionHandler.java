package com.usermanagement.system.exception.exceptionhandler;

import com.usermanagement.system.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.usermanagement.system.exception.MethodArgumentNotValidException.handleMethodArgumentNotValidException;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleInternalServerException(InternalServerErrorException ex) {
        log.error("-------- NO CONTENT FOUND EXCEPTION ------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleNoContentFoundException(NoContentFoundException ex) {
        log.error("-------- NO CONTENT FOUND EXCEPTION ------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        log.error("------- BAD REQUEST EXCEPTION -------");
        return buildResponseEntity(ex.getException());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleInvalidException(ConstraintViolationException ex) {
        log.error("------- INVALID REQUEST EXCEPTION -------");
        return buildResponseEntity(ex.getException());
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse e) {
        return new ResponseEntity<>(e, e.getResponseStatus());
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status,
                                                               WebRequest request) {
        log.error("------- METHOD ARGUMENT NOT VALID EXCEPTION -------");

        return buildResponseEntity(handleMethodArgumentNotValidException(ex));
    }
}
