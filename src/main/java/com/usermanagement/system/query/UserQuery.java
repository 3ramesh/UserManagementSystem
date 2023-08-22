package com.usermanagement.system.query;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

public class UserQuery {

    public static final String QUERY_TO_FETCH_USER_DETAILS_BY_USER_NAME =
            "SELECT" +
                    " u.id as userId," +
                    " u.userName as userName," +
                    " u.firstName as firstName,"+
                    " u.lastName as lastName," +
                    " u.email as email," +
                    " u.dateOfBirth as dateOfBirth," +
                    " u.status as status" +
                    " FROM User u" +
                    " WHERE u.status!='D'" +
                    " AND u.userName =:userName";

    public static final String QUERY_TO_FETCH_USER_DETAILS_BY_FIRST_NAME =
            "SELECT" +
                    " u.id as userId," +
                    " u.userName as userName," +
                    " u.firstName as firstName,"+
                    " u.lastName as lastName," +
                    " u.email as email," +
                    " u.dateOfBirth as dateOfBirth," +
                    " u.status as status" +
                    " FROM User u" +
                    " WHERE u.status!='D'" +
                    " AND u.firstName =:firstName";
}
