package com.usermanagement.system.constant;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

public class SwaggerConstants {

    public static String BASE_PACKAGE = "com.usermanagement.system.controller";

    public static String PATH_REGEX = "/api.*";

    public interface UserConstant {
        String BASE_API_VALUE = "This is User Resource";
        String CREATE_OPERATION = "create new user";

        String DETAILS_OPERATION = "Retrieve user information by username";

        String DETAILS_OPERATION_BY_FIRST_NAME = "Retrieve a list of users by first name";

        String DETAILS_OPERATION_BY_LAST_NAME = "Retrieve a list of users by last name";

        String UPDATE_OPERATION = "Update user information by ID";
        String DELETE_OPERATION = "Delete a User by ID, Set user status as 'D'";
    }

    public interface TestConstant {
        String BASE_API_VALUE = "This is Test Resource";
        String TEST_OPERATION = "This is Test Operation";
    }
}
