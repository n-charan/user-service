package com.learning.microservices.userservice.mapper;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.model.ApplicationLocaleResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationLocaleMapper {

    ApplicationLocaleResponseDto toDto(ApplicationLocale applicationLocale);
}
