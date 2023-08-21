package com.usermanagement.system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponseDTO implements Serializable {

    private int responseCode;

    private HttpStatus responseStatus;

    private Map<String, ?> data;
}
