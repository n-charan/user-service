package com.learning.microservices.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StateDto {

    private String name;

    private String code;
}
