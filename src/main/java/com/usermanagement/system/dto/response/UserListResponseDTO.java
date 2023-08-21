package com.usermanagement.system.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Getter
@Setter
public class UserListResponseDTO implements Serializable {

    private List<UserResponseDTO> userResponseDTOList;

    private int totalItem;
}
