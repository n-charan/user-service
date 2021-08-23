package com.learning.microservices.userservice.validator;

import com.learning.microservices.userservice.annotation.Timezone;
import com.learning.microservices.userservice.entity.TimezoneMaster;
import com.learning.microservices.userservice.repository.TimezoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimezoneValidator implements ConstraintValidator<Timezone, String> {

    @Autowired
    private TimezoneRepository timezoneRepository;

    @Override
    public void initialize(Timezone timezone) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        TimezoneMaster timezoneMaster = timezoneRepository.findByCode(value);
        return (timezoneMaster != null);
    }
}
