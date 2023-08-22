package com.usermanagement.system.constraintvalidator.validator;

import com.usermanagement.system.constraintvalidator.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.usermanagement.system.utils.PatternUtils.IsNameValid;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */

public class NameValidator implements ConstraintValidator<Name, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !IsNameValid(value);
    }
}
