package com.learning.microservices.userservice.repository;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationLocaleRepository extends JpaRepository<ApplicationLocale, Long> {
}
