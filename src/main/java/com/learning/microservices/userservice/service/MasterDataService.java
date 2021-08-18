package com.learning.microservices.userservice.service;

import com.learning.microservices.userservice.entity.*;
import com.learning.microservices.userservice.mapper.MasterDataMapper;
import com.learning.microservices.userservice.model.*;
import com.learning.microservices.userservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterDataService {

    private CountryMasterRepository countryMasterRepository;

    private StateMasterRepository stateMasterRepository;

    private TimezoneRepository timezoneRepository;

    private RoleRepository roleRepository;

    private LanguageMasterRepository languageMasterRepository;

    private MasterDataMapper masterDataMapper;

    MasterDataService(CountryMasterRepository countryMasterRepository,
                      StateMasterRepository stateMasterRepository,
                      TimezoneRepository timezoneRepository,
                      RoleRepository roleRepository,
                      LanguageMasterRepository languageMasterRepository,
                      MasterDataMapper masterDataMapper) {
        this.countryMasterRepository = countryMasterRepository;
        this.stateMasterRepository = stateMasterRepository;
        this.timezoneRepository = timezoneRepository;
        this.roleRepository = roleRepository;
        this.languageMasterRepository = languageMasterRepository;
        this.masterDataMapper = masterDataMapper;
    }

    public List<CountryDto> getCountryList() {
        List<CountryMaster> countryMasterList = countryMasterRepository.findAll();
        return countryMasterList.stream().map(countryMaster ->
                masterDataMapper.toDto(countryMaster)).collect(Collectors.toList());
    }

    public List<StateDto> getStateListByCountryId(Long countryId) {
        List<StateMaster> stateMasterList = stateMasterRepository.findAllByCountryMaster_Id(countryId);
        return stateMasterList.stream().map(stateMaster ->
                masterDataMapper.toDto(stateMaster)).collect(Collectors.toList());
    }

    public List<TimezoneDto> getTimezoneList() {
        List<TimezoneMaster> timezoneMasterList = timezoneRepository.findAll();
        return timezoneMasterList.stream().map(timezoneMaster ->
                masterDataMapper.toDto(timezoneMaster)).collect(Collectors.toList());
    }

    public List<RoleDto> getRoleList() {
        List<Role> roleList = roleRepository.findAll();
        return roleList.stream().map(role ->
                masterDataMapper.toDto(role)).collect(Collectors.toList());
    }

    public List<LanguageDto> getLanguageList() {
        List<LanguageMaster> languageMasterList = languageMasterRepository.findAll();
        return languageMasterList.stream().map(languageMaster ->
                masterDataMapper.toDto(languageMaster)).collect(Collectors.toList());
    }
}
