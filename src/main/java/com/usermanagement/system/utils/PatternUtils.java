package com.usermanagement.system.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.usermanagement.system.constant.PatternConstants.NAME_PATTERN;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */

public class PatternUtils {

    public static boolean IsNameValid(String value){
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher m = pattern.matcher(value);
        return m.find();
    }
}
