package com.learning.microservices.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean active;

    @JsonIgnore
    private Long countryId;

    @JsonIgnore
    private Long stateId;

    @JsonIgnore
    private Long timezoneId;

    @JsonIgnore
    private Long applicationLocaleId;

    private CountryDto country;

    private StateDto state;

    private TimezoneDto timezone;

    private ApplicationLocaleDto applicationLocale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Long timezoneId) {
        this.timezoneId = timezoneId;
    }

    public Long getApplicationLocaleId() {
        return applicationLocaleId;
    }

    public void setApplicationLocaleId(Long applicationLocaleId) {
        this.applicationLocaleId = applicationLocaleId;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public StateDto getState() {
        return state;
    }

    public void setState(StateDto state) {
        this.state = state;
    }

    public TimezoneDto getTimezone() {
        return timezone;
    }

    public void setTimezone(TimezoneDto timezone) {
        this.timezone = timezone;
    }

    public ApplicationLocaleDto getApplicationLocale() {
        return applicationLocale;
    }

    public void setApplicationLocale(ApplicationLocaleDto applicationLocale) {
        this.applicationLocale = applicationLocale;
    }
}
