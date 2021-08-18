package com.learning.microservices.userservice.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean activeflag;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Version
    private Integer version;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryMaster countryMaster;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateMaster stateMaster;

    @ManyToOne
    @JoinColumn(name = "timezone_id", nullable = false)
    private TimezoneMaster timezoneMaster;

    @ManyToOne
    @JoinColumn(name = "application_locale_id", nullable = false)
    private ApplicationLocale applicationLocale;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "login_complete", columnDefinition = "tinyint(1) default 0")
    private Boolean loginComplete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActiveflag() {
        return activeflag;
    }

    public void setActiveflag(Boolean activeflag) {
        this.activeflag = activeflag;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public CountryMaster getCountryMaster() {
        return countryMaster;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    public StateMaster getStateMaster() {
        return stateMaster;
    }

    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

    public TimezoneMaster getTimezoneMaster() {
        return timezoneMaster;
    }

    public void setTimezoneMaster(TimezoneMaster timezoneMaster) {
        this.timezoneMaster = timezoneMaster;
    }

    public ApplicationLocale getApplicationLocale() {
        return applicationLocale;
    }

    public void setApplicationLocale(ApplicationLocale applicationLocale) {
        this.applicationLocale = applicationLocale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoginComplete() {
        return loginComplete;
    }

    public void setLoginComplete(Boolean loginComplete) {
        this.loginComplete = loginComplete;
    }
}
