package com.learning.microservices.userservice.service;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.entity.CountryMaster;
import com.learning.microservices.userservice.entity.LanguageMaster;
import com.learning.microservices.userservice.mapper.ApplicationLocaleMapper;
import com.learning.microservices.userservice.model.ApplicationLocaleDto;
import com.learning.microservices.userservice.repository.ApplicationLocaleRepository;
import com.learning.microservices.userservice.repository.CountryMasterRepository;
import com.learning.microservices.userservice.repository.LanguageMasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationLocaleService {

    private CountryMasterRepository countryMasterRepository;

    private LanguageMasterRepository languageMasterRepository;

    private ApplicationLocaleRepository applicationLocaleRepository;

    private ApplicationLocaleMapper applicationLocaleMapper;

    ApplicationLocaleService(CountryMasterRepository countryMasterRepository,
                             LanguageMasterRepository languageMasterRepository,
                             ApplicationLocaleRepository applicationLocaleRepository,
                             ApplicationLocaleMapper applicationLocaleMapper) {
        this.countryMasterRepository = countryMasterRepository;
        this.languageMasterRepository = languageMasterRepository;
        this.applicationLocaleRepository = applicationLocaleRepository;
        this.applicationLocaleMapper = applicationLocaleMapper;
    }

    public List<ApplicationLocaleDto> getAllLocales() {
        List<ApplicationLocale> applicationLocaleList = applicationLocaleRepository.findAll();
        return applicationLocaleList.stream().map(applicationLocale ->
                applicationLocaleMapper.toDto(applicationLocale)).collect(Collectors.toList());
    }

    public ApplicationLocaleDto saveNewLocale(ApplicationLocaleDto applicationLocaleDto) {
        CountryMaster countryMaster = countryMasterRepository.getById(applicationLocaleDto.getCountryId());
        LanguageMaster languageMaster = languageMasterRepository.getById(applicationLocaleDto.getLanguageId());

        ApplicationLocale applicationLocale = new ApplicationLocale();
        applicationLocale.setCountryISO(countryMaster.getISO());
        applicationLocale.setLanguageCode(languageMaster.getCode());
        applicationLocale =  applicationLocaleRepository.save(applicationLocale);
        return applicationLocaleMapper.toDto(applicationLocale);
    }

    public void removeLocaleById(Long appLocalId) {
        ApplicationLocale applicationLocale = applicationLocaleRepository.getById(appLocalId);
        applicationLocale.setActiveflag(Boolean.FALSE);
        applicationLocaleRepository.save(applicationLocale);
    }
}
