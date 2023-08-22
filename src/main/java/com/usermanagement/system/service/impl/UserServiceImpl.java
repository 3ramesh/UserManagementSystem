package com.usermanagement.system.service.impl;

import com.usermanagement.system.dto.request.UserRequestDTO;
import com.usermanagement.system.dto.request.UserUpdateRequestDTO;
import com.usermanagement.system.dto.response.StatusResponseDTO;
import com.usermanagement.system.dto.response.UserListResponseDTO;
import com.usermanagement.system.dto.response.UserResponseDTO;
import com.usermanagement.system.exception.BadRequestException;
import com.usermanagement.system.exception.NoContentFoundException;
import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.UserRepository;
import com.usermanagement.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

import static com.usermanagement.system.constant.CommonLogConstant.*;
import static com.usermanagement.system.constant.ErrorMessageConstants.*;
import static com.usermanagement.system.utils.DateUtils.getDifferenceBetweenTwoTime;
import static com.usermanagement.system.utils.DateUtils.getTimeInMillisecondsFromLocalDate;
import static com.usermanagement.system.utils.UserUtils.*;
import static com.usermanagement.system.utils.ValidationUtils.validateConstraintViolation;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Validator validator;


    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public StatusResponseDTO save(UserRequestDTO requestDTO) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(CREATING_PROCESS_STARTED, USER);

        validateConstraintViolation(validator.validate(requestDTO));

        validateUnique(requestDTO.getUserName(), requestDTO.getEmail());

        validDateOfBirth(requestDTO.getDateOfBirth());

        User user = saveUser(parseToSaveUser(requestDTO));

        log.info(CREATING_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));

        return parseToSaveUserResponseDTO(user.getId());
    }


    @Override
    public UserResponseDTO fetchDetailsByUserName(String userName) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(RETRIEVING_BY_USERNAME_PROCESS_STARTED, USER);

        UserResponseDTO responseDTO = userRepository.fetchDetailsByUserName(userName);

        log.info(RETRIEVING_BY_USERNAME_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));

        return responseDTO;
    }

    @Override
    public UserListResponseDTO fetchUserListByFirstName(String firstName, Pageable pageable) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(RETRIEVING_LIST_BY_FIRST_NAME_PROCESS_STARTED, USER);

        UserListResponseDTO listResponseDTO = userRepository.fetchUserListByFirstName(firstName, pageable);

        log.info(RETRIEVING_LIST_BY_FIRST_NAME_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));


        return listResponseDTO;
    }

    @Override
    public UserListResponseDTO fetchUserListByLastName(String lastName, Pageable pageable) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(RETRIEVING_LIST_BY_LAST_NAME_PROCESS_STARTED, USER);

        UserListResponseDTO listResponseDTO = userRepository.fetchUserListByLastName(lastName, pageable);

        log.info(RETRIEVING_LIST_BY_LAST_NAME_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));

        return listResponseDTO;
    }

    @Override
    public UserResponseDTO fetchDetailsByUserEmail(String email) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(RETRIEVING_BY_EMAIL_PROCESS_STARTED, USER);

        UserResponseDTO responseDTO = userRepository.fetchDetailsByUserEmail(email);

        log.info(RETRIEVING_BY_EMAIL_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));

        return responseDTO;
    }

    @Override
    public StatusResponseDTO update(UserUpdateRequestDTO updateRequestDTO, Long id) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(UPDATING_PROCESS_STARTED, USER);

        validateConstraintViolation(validator.validate(updateRequestDTO));

        validDateOfBirth(updateRequestDTO.getDateOfBirth());

        User user = findById(id);

        parseToUpdateUserDetails(updateRequestDTO, user);

        log.info(UPDATING_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));

        return parseToSaveUserResponseDTO(user.getId());
    }

    @Override
    public StatusResponseDTO delete(Long id) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(DELETING_PROCESS_STARTED, USER);

        User user = findById(id);

        parseToDeleteUser(user);

        log.info(DELETING_PROCESS_COMPLETED, USER, getDifferenceBetweenTwoTime(startTime));

        return parseToDeleteUserResponseDTO();
    }


    private void validateUnique(String userName, String email) {
        User userByUserName = userRepository.findUserByUserName(userName).orElse(null);

        if (userByUserName != null) {
            throw new BadRequestException(USER_NAME_ALREADY_EXISTS);
        }

        User userByEmail = userRepository.findUserByEmail(email).orElse(null);

        if (userByEmail != null) {
            throw new BadRequestException(EMAIL_ALREADY_EXISTS);
        }


    }

    private void validDateOfBirth(Date dateOfBirth) {

        LocalDate currentDate = LocalDate.now();

        LocalDate dateOfBirthLocal = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (dateOfBirthLocal.isAfter(currentDate)) {

            throw new BadRequestException(DATE_OF_BIRTH_NOT_FUTURE);

        }
    }

    private User findById(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> USER_WITH_GIVEN_ID_NOT_FOUND.apply(userId));
    }

    private User saveUser(User user) {
        return userRepository.save(user);
    }

    private Function<Long, NoContentFoundException> USER_WITH_GIVEN_ID_NOT_FOUND = (id) -> {
        log.error(CONTENT_NOT_FOUND_BY_ID, USER, id);
        throw new NoContentFoundException(String.format(NO_RECORD_FOUND, USER), "id", id.toString());
    };

}
