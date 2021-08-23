package com.learning.microservices.userservice.repository;

import com.learning.microservices.userservice.entity.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@Repository
public interface StateMasterRepository extends JpaRepository<StateMaster, Long> {

    List<StateMaster> findAllByCountryMaster_Id(Long countryId);

    StateMaster findByCountryMasterIdAndCode(Long countryId, String code);
}
