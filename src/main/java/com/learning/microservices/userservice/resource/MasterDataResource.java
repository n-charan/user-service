package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.model.*;
import com.learning.microservices.userservice.service.MasterDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/master-data")
public class MasterDataResource {

    private MasterDataService masterDataService;

    MasterDataResource(MasterDataService masterDataService) {
        this.masterDataService = masterDataService;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> getListOfCountries() {
        List<CountryDto> countryList = masterDataService.getCountryList();
        return ResponseEntity.ok(countryList);
    }

    @GetMapping("/countries/{id}/states")
    public ResponseEntity<List<StateDto>> getStateListByCountryId(@PathVariable(name = "id") Long countryId) {
        List<StateDto> stateList = masterDataService.getStateListByCountryId(countryId);
        return ResponseEntity.ok(stateList);
    }

    @GetMapping("/time-zones")
    public ResponseEntity<List<TimezoneDto>> getListofTimezones() {
        List<TimezoneDto> timezoneList = masterDataService.getTimezoneList();
        return ResponseEntity.ok(timezoneList);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> getListofRoles() {
        List<RoleDto> roleList = masterDataService.getRoleList();
        return ResponseEntity.ok(roleList);
    }

    @GetMapping("/languages")
    public ResponseEntity<List<LanguageDto>> getListofLanguages() {
        List<LanguageDto> languageList = masterDataService.getLanguageList();
        return ResponseEntity.ok(languageList);
    }

}
