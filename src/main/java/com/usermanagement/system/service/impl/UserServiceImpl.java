package com.usermanagement.system.service.impl;

import com.usermanagement.system.dto.request.UserRequestDTO;
import com.usermanagement.system.dto.response.StatusResponseDTO;
import com.usermanagement.system.dto.response.UserListResponseDTO;
import com.usermanagement.system.dto.response.UserResponseDTO;
import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.UserRepository;
import com.usermanagement.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.usermanagement.system.utils.UserUtils.parseToSaveUser;
import static com.usermanagement.system.utils.UserUtils.parseToSaveUserResponseDTO;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public StatusResponseDTO save(UserRequestDTO requestDTO) {

        User user = saveUser(parseToSaveUser(requestDTO));

        return parseToSaveUserResponseDTO(user.getId());
    }

    @Override
    public UserResponseDTO fetchDetailsByUserName(String userName) {

        UserResponseDTO responseDTO = userRepository.fetchDetailsByUserName(userName);

        return responseDTO;
    }

    @Override
    public UserListResponseDTO fetchUserListByFirstName(String firstName) {

        UserListResponseDTO listResponseDTO = userRepository.fetchUserListByFirstName(firstName);

        return listResponseDTO;
    }

    private User saveUser(User user) {
        return userRepository.save(user);
    }
}
