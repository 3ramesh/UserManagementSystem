package com.usermanagement.system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    private Date dateOfBirth;

    // Doesn't give access to update username and email because of unique key.
}
