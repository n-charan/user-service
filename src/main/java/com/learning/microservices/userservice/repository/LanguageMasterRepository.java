package com.learning.microservices.userservice.repository;

import com.learning.microservices.userservice.entity.LanguageMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMasterRepository extends JpaRepository<LanguageMaster, Long> {
}
