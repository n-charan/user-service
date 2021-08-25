package com.learning.microservices.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private CountryDto country;

    private StateDto state;

    private TimezoneDto timezone;

    private ApplicationLocaleResponseDto applicationLocale;

    private RoleDto role;
}
