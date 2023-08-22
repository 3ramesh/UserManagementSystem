package com.usermanagement.system.constant;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

public class WebResourceKeyConstants {

    public static final String API = "/api";

    public static final String USER_NAME_PATH_VARIABLE_BASE = "/{username}";

    public static final String USER_ID_PATH_VARIABLE_BASE = "/{id}";

    public static final String FIRST_NAME = "first-name";

    public static final String LAST_NAME = "last-name";

    public static final String FIRST_NAME_PATH_VARIABLE_BASE = "/{firstName}";

    public static final String LAST_NAME_PATH_VARIABLE_BASE = "/{lastName}";




    public interface UserResourceConstant {
        String BASE_USER_RESOURCE = "/users";
    }

    public interface TestResourceConstant {
        String BASE_TEST_RESOURCE = "/test";
    }
}
