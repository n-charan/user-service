package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Locale;

public class ApplicationLocaleDto {

    private Long id;

    private String locale;

    @JsonIgnore
    private String ISO;

    @JsonIgnore
    private String code;

    private Long countryId;

    private Long languageId;

    public ApplicationLocaleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocale() {
        this.locale = new Locale(this.code, this.ISO).toString();
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }
}
