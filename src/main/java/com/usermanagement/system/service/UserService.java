package com.usermanagement.system.service;

import com.usermanagement.system.dto.request.UserRequestDTO;
import com.usermanagement.system.dto.response.StatusResponseDTO;
import com.usermanagement.system.dto.response.UserListResponseDTO;
import com.usermanagement.system.dto.response.UserResponseDTO;
import org.springframework.data.domain.Pageable;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

public interface UserService {

    StatusResponseDTO save(UserRequestDTO requestDTO);

    UserResponseDTO fetchDetailsByUserName(String userName);

    UserListResponseDTO fetchUserListByFirstName(String firstName, Pageable pageable);

    StatusResponseDTO update(UserRequestDTO requestDTO, Long id);

    StatusResponseDTO delete(Long id);
}
