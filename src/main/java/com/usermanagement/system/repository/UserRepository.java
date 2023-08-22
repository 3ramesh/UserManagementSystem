package com.usermanagement.system.repository;

import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.status!='D'")
    Optional<User> findUserByUserName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.status!='D'")
    Optional<User> findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.status!='D'")
    Optional<User> findUserById(@Param("id") Long id);
}
