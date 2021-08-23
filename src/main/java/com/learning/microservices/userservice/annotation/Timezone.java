package com.learning.microservices.userservice.annotation;

import com.learning.microservices.userservice.validator.TimezoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimezoneValidator.class)
@Documented
public @interface Timezone {
    String message() default "Invalid Timezone";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
