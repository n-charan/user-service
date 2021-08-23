package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.microservices.userservice.annotation.ApplicationLocale;
import com.learning.microservices.userservice.annotation.Country;
import com.learning.microservices.userservice.annotation.Role;
import com.learning.microservices.userservice.annotation.Timezone;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email is not valid")
    private String email;

    private Boolean active;

    @NotNull(message = "Country ISO cannot be null")
    @Country
    private String countryISO;

    private String stateCode;

    @NotNull(message = "Timezone cannot be null")
    @Timezone
    private String timezoneCode;

    @NotNull(message = "Application Locale cannot be null")
    @ApplicationLocale
    private String appLocale;

    @NotNull(message = "Role cannot be null")
    @Role
    private String roleCode;

    private CountryDto country;

    private StateDto state;

    private TimezoneDto timezone;

    private ApplicationLocaleDto applicationLocale;

    private RoleDto role;
}
