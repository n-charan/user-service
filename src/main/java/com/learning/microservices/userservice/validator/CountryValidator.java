package com.learning.microservices.userservice.validator;

import com.learning.microservices.userservice.annotation.Country;
import com.learning.microservices.userservice.entity.CountryMaster;
import com.learning.microservices.userservice.repository.CountryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<Country, String> {

    @Autowired
    private CountryMasterRepository countryMasterRepository;

    @Override
    public void initialize(Country country) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        CountryMaster countryMaster = countryMasterRepository.findByISO(value);
        return (countryMaster != null);
    }
}
