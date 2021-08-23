package com.learning.microservices.userservice.repository;

import com.learning.microservices.userservice.entity.CountryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster, Long> {

    CountryMaster findByISO(String ISO);
}
