package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean active;

    @JsonIgnore
    private Long countryId;

    @JsonIgnore
    private Long stateId;

    @JsonIgnore
    private Long timezoneId;

    @JsonIgnore
    private Long applicationLocaleId;

    private CountryDto country;

    private StateDto state;

    private TimezoneDto timezone;

    private ApplicationLocaleDto applicationLocale;
}
