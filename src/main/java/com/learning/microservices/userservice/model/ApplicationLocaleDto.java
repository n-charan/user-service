package com.learning.microservices.userservice.model;

import com.learning.microservices.userservice.annotation.Country;
import com.learning.microservices.userservice.annotation.Language;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ApplicationLocaleDto {

    private Long id;

    private String locale;

    @NotNull(message = "Country cannot be null")
    @Country
    private String countryISO;

    @NotNull(message = "Language cannot be null")
    @Language
    private String languageCode;
}

