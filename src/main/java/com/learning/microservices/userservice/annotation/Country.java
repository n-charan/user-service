package com.learning.microservices.userservice.annotation;

import com.learning.microservices.userservice.validator.CountryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryValidator.class)
@Documented
public @interface Country {
    String message() default "Invalid Country";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
