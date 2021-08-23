package com.learning.microservices.userservice.annotation;

import com.learning.microservices.userservice.validator.ApplicationLocaleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ApplicationLocaleValidator.class)
@Documented
public @interface ApplicationLocale {
    String message() default "Invalid Application Locale";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
