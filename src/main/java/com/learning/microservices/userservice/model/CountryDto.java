package com.learning.microservices.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDto {

    private String name;

    private String ISO;
}
