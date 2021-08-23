package com.learning.microservices.userservice.annotation;

import com.learning.microservices.userservice.validator.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleValidator.class)
@Documented
public @interface Role {
    String message() default "Invalid Role";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
