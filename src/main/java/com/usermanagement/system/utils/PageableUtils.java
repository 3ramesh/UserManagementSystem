package com.usermanagement.system.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.Query;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */

public class PageableUtils {

    public static Pageable getPageable(int page, int size) {
        return PageRequest.of(page, size);
    }

    public static BiConsumer<Pageable, Query> addPagination = (pageable, query) -> {
        if (!Objects.isNull(pageable) && pageable.getPageNumber() != 0) {
            query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        }
    };
}
