package com.learning.microservices.userservice.service;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.exception.ResourceNotFoundException;
import com.learning.microservices.userservice.mapper.ApplicationLocaleMapper;
import com.learning.microservices.userservice.model.ApplicationLocaleDto;
import com.learning.microservices.userservice.repository.ApplicationLocaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ApplicationLocaleService {

    private ApplicationLocaleRepository applicationLocaleRepository;

    private ApplicationLocaleMapper applicationLocaleMapper;

    ApplicationLocaleService(ApplicationLocaleRepository applicationLocaleRepository,
                             ApplicationLocaleMapper applicationLocaleMapper) {
        this.applicationLocaleRepository = applicationLocaleRepository;
        this.applicationLocaleMapper = applicationLocaleMapper;
    }

    public List<ApplicationLocaleDto> getAllLocales() {
        List<ApplicationLocale> applicationLocaleList = applicationLocaleRepository.findAll();
        return applicationLocaleList.stream().map(applicationLocale ->
                applicationLocaleMapper.toDto(applicationLocale)).collect(Collectors.toList());
    }

    public ApplicationLocaleDto saveNewLocale(ApplicationLocaleDto applicationLocaleDto) {
        ApplicationLocale applicationLocale = new ApplicationLocale();
        Locale locale = new Locale(applicationLocaleDto.getLanguageCode(), applicationLocaleDto.getCountryISO());
        applicationLocale.setLocale(locale.toString());
        applicationLocale.setActiveflag(Boolean.TRUE);
        applicationLocale =  applicationLocaleRepository.save(applicationLocale);
        return applicationLocaleMapper.toDto(applicationLocale);
    }

    public void deleteLocale(String locale) {
        ApplicationLocale applicationLocale = applicationLocaleRepository.findByLocale(locale);
        if (applicationLocale == null) {
            throw new ResourceNotFoundException("Application Locale Entity Not Found");
        }
        applicationLocale.setActiveflag(Boolean.FALSE);
        applicationLocaleRepository.save(applicationLocale);
    }
}
