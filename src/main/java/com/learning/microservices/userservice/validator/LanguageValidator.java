package com.learning.microservices.userservice.validator;

import com.learning.microservices.userservice.annotation.Language;
import com.learning.microservices.userservice.entity.LanguageMaster;
import com.learning.microservices.userservice.repository.LanguageMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageValidator implements ConstraintValidator<Language, String> {

    @Autowired
    private LanguageMasterRepository languageMasterRepository;

    @Override
    public void initialize(Language language) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        LanguageMaster languageMaster = languageMasterRepository.findByCode(value);
        return (languageMaster != null);
    }
}
