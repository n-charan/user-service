package com.learning.microservices.userservice.repository;

import com.learning.microservices.userservice.entity.LanguageMaster;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
public class LanguageMasterRepositoryTest {

    @Autowired
    private LanguageMasterRepository languageMasterRepository;

    @Test
    public void findByISOTest() {
        LanguageMaster languageMaster = languageMasterRepository.findByCode("en");
        assertNotNull(languageMaster);
    }
}
