package com.learning.microservices.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "state_master")
@Data
@NoArgsConstructor
public class StateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryMaster countryMaster;
}
