package com.learning.microservices.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CountryDto {

    private Long id;

    private String name;
}
