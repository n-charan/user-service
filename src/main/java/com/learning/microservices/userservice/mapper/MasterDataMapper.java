package com.learning.microservices.userservice.mapper;

import com.learning.microservices.userservice.entity.*;
import com.learning.microservices.userservice.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MasterDataMapper {

    CountryDto toDto(CountryMaster countryMaster);

    StateDto toDto(StateMaster stateMaster);

    LanguageDto toDto(LanguageMaster languageMaster);

    RoleDto toDto(Role role);

    TimezoneDto toDto(TimezoneMaster timezoneMaster);
}
