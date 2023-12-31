package com.usermanagement.system.constraintvalidator;

import com.usermanagement.system.constraintvalidator.validator.NameValidator;

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
@Target({ FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NameValidator.class})
public @interface Name {

    String message() default "contains name characters";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
