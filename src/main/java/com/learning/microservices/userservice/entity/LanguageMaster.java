package com.learning.microservices.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "language_master")
@Data
@NoArgsConstructor
public class LanguageMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = false, length = 50)
    private String code;
}
