package com.learning.microservices.userservice.validator;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.repository.ApplicationLocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ApplicationLocaleValidator implements ConstraintValidator<com.learning.microservices.userservice.annotation.ApplicationLocale, String> {

    @Autowired
    private ApplicationLocaleRepository applicationLocaleRepository;

    @Override
    public void initialize(com.learning.microservices.userservice.annotation.ApplicationLocale applicationLocale) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        ApplicationLocale applicationLocale = applicationLocaleRepository.findByLocale(value);
        return (applicationLocale != null);
    }
}
