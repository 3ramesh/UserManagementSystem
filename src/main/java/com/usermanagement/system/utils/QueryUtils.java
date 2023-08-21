package com.usermanagement.system.utils;

import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

public class QueryUtils {

    public static BiFunction<EntityManager, String, Query> createQuery = (EntityManager::createQuery);

    public static <T> List<T> transformQueryToResultList(Query query, Class<T> requestDTO) {
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(requestDTO))
                .getResultList();
    }

    public static <T> T transformQueryToSingleResult(Query query, Class<T> requestDTO) {
        return (T) query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(requestDTO))
                .getSingleResult();
    }
}
