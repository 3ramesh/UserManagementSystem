package com.usermanagement.system.repository;

import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
