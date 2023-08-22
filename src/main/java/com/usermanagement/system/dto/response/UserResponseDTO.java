package com.usermanagement.system.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO implements Serializable {

    private Long userId;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private Date dateOfBirth;

    private Character status;
}
