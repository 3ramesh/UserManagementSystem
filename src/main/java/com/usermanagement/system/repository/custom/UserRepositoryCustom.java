package com.usermanagement.system.repository.custom;

import com.usermanagement.system.dto.response.UserListResponseDTO;
import com.usermanagement.system.dto.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Repository
@Qualifier("userRepositoryCustom")
public interface UserRepositoryCustom {

    UserResponseDTO fetchDetailsByUserName(String userName);

    UserListResponseDTO fetchUserListByFirstName(String firstName, Pageable pageable);
}
