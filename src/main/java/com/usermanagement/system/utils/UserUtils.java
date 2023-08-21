package com.usermanagement.system.utils;

import com.usermanagement.system.dto.request.UserRequestDTO;
import com.usermanagement.system.dto.response.StatusResponseDTO;
import com.usermanagement.system.model.User;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

public class UserUtils {

    public static User parseToSaveUser(UserRequestDTO requestDTO){

        User user = new User();
        user.setUserName(requestDTO.getUserName());
        user.setFirstName(requestDTO.getFirstName());
        user.setLastName(requestDTO.getLastName());
        user.setEmail(requestDTO.getEmail());
        user.setDateOfBirth(requestDTO.getDateOfBirth());

        return user;
    }

    public static StatusResponseDTO parseToSaveUserResponseDTO(Long userId) {

        Map<String, Object> data = new HashMap<>();
        data.put("userId", userId);

        StatusResponseDTO responseDTO = new StatusResponseDTO();
        responseDTO.setData(data);
        responseDTO.setResponseCode(OK.value());
        responseDTO.setResponseStatus(OK);

        return responseDTO;
    }
}
