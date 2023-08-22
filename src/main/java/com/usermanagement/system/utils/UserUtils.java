package com.usermanagement.system.utils;

import com.usermanagement.system.dto.request.UserRequestDTO;
import com.usermanagement.system.dto.request.UserUpdateRequestDTO;
import com.usermanagement.system.dto.response.StatusResponseDTO;
import com.usermanagement.system.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.usermanagement.system.constant.StatusConstant.*;
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
        user.setStatus(ACTIVE);

        return user;
    }

    public static User parseToUpdateUserDetails(UserUpdateRequestDTO updateRequestDTO, User user){

        user.setFirstName(updateRequestDTO.getFirstName());
        user.setLastName(updateRequestDTO.getLastName());
        user.setDateOfBirth(updateRequestDTO.getDateOfBirth());
        user.setStatus(UPDATED);

        return user;
    }

    public static void parseToDeleteUser(User user){

        user.setStatus(DELETED);
    }

    public static StatusResponseDTO parseToDeleteUserResponseDTO() {

        StatusResponseDTO responseDTO = new StatusResponseDTO();
        responseDTO.setResponseCode(OK.value());
        responseDTO.setResponseStatus(OK);

        return responseDTO;
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
