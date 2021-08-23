package com.learning.microservices.userservice.repository;

import com.learning.microservices.userservice.entity.TimezoneMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimezoneRepository extends JpaRepository<TimezoneMaster, Long> {

    TimezoneMaster findByCode(String code);
}
