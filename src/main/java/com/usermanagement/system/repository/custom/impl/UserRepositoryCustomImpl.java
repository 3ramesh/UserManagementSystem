package com.usermanagement.system.repository.custom.impl;

import com.usermanagement.system.dto.response.UserListResponseDTO;
import com.usermanagement.system.dto.response.UserResponseDTO;
import com.usermanagement.system.exception.NoContentFoundException;
import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.custom.UserRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Supplier;

import static com.usermanagement.system.query.UserQuery.*;
import static com.usermanagement.system.utils.PageableUtils.addPagination;
import static com.usermanagement.system.utils.QueryUtils.*;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Repository
@Transactional(readOnly = true)
@Slf4j
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserResponseDTO fetchDetailsByUserName(String userName) {
        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_USER_DETAILS_BY_USER_NAME)
                .setParameter("userName", userName);

        try {
            return transformQueryToSingleResult(query, UserResponseDTO.class);
        } catch (NoResultException e) {
            throw USER_NOT_FOUND.get();
        }

    }

    @Override
    public UserListResponseDTO fetchUserListByFirstName(String firstName, Pageable pageable) {

        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_USER_DETAILS_BY_FIRST_NAME)
                .setParameter("firstName", firstName);

        int totalItems = query.getResultList().size();

        addPagination.accept(pageable, query);

        List<UserResponseDTO> results = transformQueryToResultList(query, UserResponseDTO.class);

        if (results.isEmpty()) {
            throw USER_NOT_FOUND.get();
        } else {
            UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
            userListResponseDTO.setTotalItem(totalItems);
            userListResponseDTO.setUserResponseDTOList(results);
            return userListResponseDTO;
        }

    }

    @Override
    public UserListResponseDTO fetchUserListByLastName(String lastName, Pageable pageable) {

        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_USER_DETAILS_BY_LAST_NAME)
                .setParameter("lastName", lastName);

        int totalItems = query.getResultList().size();

        addPagination.accept(pageable, query);

        List<UserResponseDTO> results = transformQueryToResultList(query, UserResponseDTO.class);

        if (results.isEmpty()) {
            throw USER_NOT_FOUND.get();
        } else {
            UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
            userListResponseDTO.setTotalItem(totalItems);
            userListResponseDTO.setUserResponseDTOList(results);
            return userListResponseDTO;
        }

    }

    @Override
    public UserResponseDTO fetchDetailsByUserEmail(String email) {
        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_USER_DETAILS_BY_USER_EMAIL)
                .setParameter("email", email);

        try {
            return transformQueryToSingleResult(query, UserResponseDTO.class);
        } catch (NoResultException e) {
            throw USER_NOT_FOUND.get();
        }

    }


    private Supplier<NoContentFoundException> USER_NOT_FOUND = () -> new NoContentFoundException(User.class);

}
