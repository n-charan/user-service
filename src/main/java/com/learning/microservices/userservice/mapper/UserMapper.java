package com.learning.microservices.userservice.mapper;

import com.learning.microservices.userservice.entity.User;
import com.learning.microservices.userservice.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ApplicationLocaleMapper.class, MasterDataMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(target = "country", source = "countryMaster"),
            @Mapping(target = "state", source = "stateMaster"),
            @Mapping(target = "timezone", source = "timezoneMaster"),
            @Mapping(target = "applicationLocale", source = "applicationLocale"),
    })
    UserDto toDto(User user);
}
