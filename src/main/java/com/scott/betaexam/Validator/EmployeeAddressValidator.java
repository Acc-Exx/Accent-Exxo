package com.scott.betaexam.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {AddressValidator.class})
public @interface EmployeeAddressValidator {
    String message() default "City and state should not be blank";
    Class<?>[] groups() default {};
    Class <?extends Payload> [] payload() default{};
}
