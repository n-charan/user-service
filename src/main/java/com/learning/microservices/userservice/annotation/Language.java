package com.learning.microservices.userservice.annotation;

import com.learning.microservices.userservice.validator.LanguageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({
        ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LanguageValidator.class)
@Documented
public @interface Language {
    String message() default "Language is not valid";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
