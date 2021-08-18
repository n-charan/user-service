package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
public class ApplicationLocaleDto {

    private Long id;

    private String locale;

    @JsonIgnore
    private String ISO;

    @JsonIgnore
    private String code;

    private Long countryId;

    private Long languageId;

    public String getLocale() {
        this.locale = new Locale(this.code, this.ISO).toString();
        return this.locale;
    }
}
