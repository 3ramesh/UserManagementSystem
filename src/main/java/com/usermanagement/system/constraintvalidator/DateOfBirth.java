package com.usermanagement.system.constraintvalidator;

import com.usermanagement.system.constraintvalidator.validator.DateOfBirthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Ramesh Jamakatel on 8/22/2023
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {DateOfBirthValidator.class})
public @interface DateOfBirth {

    String message() default "Invalid Date of birth";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
