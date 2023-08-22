package com.usermanagement.system.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */

public class StringUtil {

    public static String splitByCharacterTypeCamelCase(String name) {
        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase
                (name.replaceAll("\\d+", "")), " ");
    }

}
