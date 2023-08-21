package com.usermanagement.system.repository.custom.impl;

import com.usermanagement.system.dto.response.UserListResponseDTO;
import com.usermanagement.system.dto.response.UserResponseDTO;
import com.usermanagement.system.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import static com.usermanagement.system.query.UserQuery.QUERY_TO_FETCH_USER_DETAILS_BY_FIRST_NAME;
import static com.usermanagement.system.query.UserQuery.QUERY_TO_FETCH_USER_DETAILS_BY_USER_NAME;
import static com.usermanagement.system.utils.QueryUtils.*;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserResponseDTO fetchDetailsByUserName(String userName) {
        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_USER_DETAILS_BY_USER_NAME)
                .setParameter("userName", userName);

        // try {
        return transformQueryToSingleResult(query, UserResponseDTO.class);
        // } catch (NoResultException e) {
        // throw USER_WITH_GIVEN_ID_NOT_FOUND.apply(userName);
        //  }

    }

    @Override
    public UserListResponseDTO fetchUserListByFirstName(String firstName) {

        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_USER_DETAILS_BY_FIRST_NAME)
                .setParameter("firstName", firstName);

        int totalItems = query.getResultList().size();

        List<UserResponseDTO> results = transformQueryToResultList(query, UserResponseDTO.class);

       /* if (results.isEmpty()) {
            throw BATTERY_NOT_FOUND.get();
        } else {
       */
            UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
            userListResponseDTO.setTotalItem(totalItems);
            userListResponseDTO.setUserResponseDTOList(results);
      //  }


        return userListResponseDTO;
    }
}
