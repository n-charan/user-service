package com.learning.microservices.userservice.service;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.model.ApplicationLocaleRequestDto;
import com.learning.microservices.userservice.model.ApplicationLocaleResponseDto;
import com.learning.microservices.userservice.repository.ApplicationLocaleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ApplicationLocaleServiceTest {

    @Mock
    private ApplicationLocaleRepository applicationLocaleRepository;

    @InjectMocks
    private ApplicationLocaleService applicationLocaleService;

    @Test
    public void getAllLocalesTest() {
        ApplicationLocale applicationLocale = new ApplicationLocale();
        applicationLocale.setActiveflag(Boolean.TRUE);
        applicationLocale.setLocale("en_US");

        List<ApplicationLocale> applicationLocaleList = new ArrayList<>();
        applicationLocaleList.add(applicationLocale);

        when(applicationLocaleRepository.findAll()).thenReturn(applicationLocaleList);

        List<ApplicationLocaleResponseDto> applicationLocaleDtoList = applicationLocaleService.getAllLocales();
        assertNotNull(applicationLocaleDtoList);
        assertEquals("en_US", applicationLocaleDtoList.get(0).getLocale());
    }
}
