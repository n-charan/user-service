package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDto {

    private Long id;

    private String name;

    @JsonIgnore
    private String ISO;
}
