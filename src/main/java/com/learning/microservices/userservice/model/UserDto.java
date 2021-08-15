package com.learning.microservices.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String active;

    private CountryDto country;

    private TimezoneDto timezone;
}
