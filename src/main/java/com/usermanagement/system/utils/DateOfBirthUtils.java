package com.usermanagement.system.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.usermanagement.system.utils.DateUtils.getCurrentEnglishYearFromString;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */

public class DateOfBirthUtils {

    public static boolean isDateOfBirthValid(String dateOfBirth) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate dob = LocalDate.parse(dateOfBirth, dateFormatter);
            LocalDate currentDate = LocalDate.now();

            // Assuming a realistic age range, e.g., 120 years
            LocalDate earliestValidDate = currentDate.minusYears(120);
            LocalDate latestValidDate = currentDate.minusYears(1);

            if (dob.isBefore(earliestValidDate) || dob.isAfter(latestValidDate)) {
                throw new IllegalArgumentException("Date of birth is not within the valid range.");
            }

            return true;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for date of birth.");
        }
    }
}



