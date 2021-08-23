package com.learning.microservices.userservice.validator;

import com.learning.microservices.userservice.annotation.Role;
import com.learning.microservices.userservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<Role, String> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void initialize(Role role) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        com.learning.microservices.userservice.entity.Role role = roleRepository.findByCode(value);
        return (role != null);
    }
}
