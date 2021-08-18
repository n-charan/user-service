package com.learning.microservices.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application_locale")
@Data
@NoArgsConstructor
public class ApplicationLocale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastupdated;

    @Column(name = "activeflag", columnDefinition = "tinyint(1) default 1")
    private Boolean activeflag;

    @Column(name="country_iso", length = 5)
    private String countryISO;

    @Column(length = 5)
    private String languageCode;
}
