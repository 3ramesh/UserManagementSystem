package com.usermanagement.system.exception;

import com.usermanagement.system.utils.ExceptionUtils;
import lombok.Getter;

import static com.usermanagement.system.utils.ExceptionUtils.generateMessage;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Getter
public class InternalServerErrorException extends RuntimeException{

    private ExceptionResponse exception;

    public InternalServerErrorException(Class clazz, String debugMessage) {
        super(generateMessage(clazz));
        exception = ExceptionResponse.builder()
                .errorMessage(generateMessage(clazz))
                .debugMessage(debugMessage)
                .responseStatus(INTERNAL_SERVER_ERROR)
                .responseCode(INTERNAL_SERVER_ERROR.value())
                .timeStamp(ExceptionUtils.getLocalDateTime())
                .build();

    }
}
