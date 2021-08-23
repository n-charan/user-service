package com.learning.microservices.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime localDateTime;
    private String status;
    private String error;
    private String message;
}
