package com.learning.microservices.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application_locale")
@Data
@NoArgsConstructor
@Where(clause = "activeflag=1")
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

    @Column(name="locale", length = 10)
    private String locale;
}
