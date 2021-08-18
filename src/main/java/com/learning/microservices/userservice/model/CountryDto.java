package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CountryDto {

    private Long id;

    private String name;

    @JsonIgnore
    private String ISO;

    public CountryDto() {
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

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }
}
