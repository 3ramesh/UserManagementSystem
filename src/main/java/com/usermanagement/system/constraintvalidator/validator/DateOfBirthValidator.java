package com.usermanagement.system.constraintvalidator.validator;

import com.usermanagement.system.constraintvalidator.DateOfBirth;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.usermanagement.system.utils.DateOfBirthUtils.isDateOfBirthValid;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Component
public class DateOfBirthValidator implements ConstraintValidator<DateOfBirth, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return isDateOfBirthValid(s);
    }
}
