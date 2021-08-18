package com.learning.microservices.userservice.mapper;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.model.ApplicationLocaleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ApplicationLocaleMapper {

    @Mappings({
            @Mapping(target = "ISO", source = "countryISO"),
            @Mapping(target = "code", source = "languageCode")
    })
    ApplicationLocaleDto toDto(ApplicationLocale applicationLocale);
}
