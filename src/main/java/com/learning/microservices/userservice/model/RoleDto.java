package com.learning.microservices.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {

    private String name;

    private String code;
}
