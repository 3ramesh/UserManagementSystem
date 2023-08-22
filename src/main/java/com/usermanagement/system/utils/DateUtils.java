package com.usermanagement.system.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */

public class DateUtils {

    public static Integer getCurrentEnglishYearFromString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        String currentYear= formatter.format(date).split("-")[0];

        return Integer.valueOf(currentYear);
    }

    public static Long getDifferenceBetweenTwoTime(Long startTime) {
        return getTimeInMillisecondsFromLocalDate() - startTime;
    }

    public static Long getTimeInMillisecondsFromLocalDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return Timestamp.valueOf(localDate).getTime();
    }

}
