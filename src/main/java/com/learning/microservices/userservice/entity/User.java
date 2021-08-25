package com.learning.microservices.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean activeflag;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastupdated;

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

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Override
    public String toString() {
        return "";
    }
}
