package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LanguageDto {

    private Long id;

    private String name;

    @JsonIgnore
    private String code;

    public LanguageDto() {
    }

    public LanguageDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
