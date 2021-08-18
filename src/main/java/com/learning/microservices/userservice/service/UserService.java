package com.learning.microservices.userservice.service;

import com.learning.microservices.userservice.entity.User;
import com.learning.microservices.userservice.mapper.UserMapper;
import com.learning.microservices.userservice.model.UserDto;
import com.learning.microservices.userservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CountryMasterRepository countryMasterRepository;

    private final StateMasterRepository stateMasterRepository;

    private final TimezoneRepository timezoneRepository;

    private final ApplicationLocaleRepository applicationLocaleRepository;

    private final UserMapper userMapper;

    UserService(UserRepository userRepository,
                UserMapper userMapper,
                CountryMasterRepository countryMasterRepository,
                StateMasterRepository stateMasterRepository,
                TimezoneRepository timezoneRepository,
                ApplicationLocaleRepository applicationLocaleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.countryMasterRepository = countryMasterRepository;
        this.stateMasterRepository = stateMasterRepository;
        this.timezoneRepository = timezoneRepository;
        this.applicationLocaleRepository = applicationLocaleRepository;
    }

    public List<UserDto> getAllUsers(Boolean active, String role) {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user ->
                userMapper.toDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    public UserDto getUserDetails(Long userId) {
        User user = userRepository.getById(userId);
        return userMapper.toDto(user);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setCountryMaster(countryMasterRepository.getById(userDto.getCountryId()));
        if(userDto.getStateId() != null) {
            user.setStateMaster(stateMasterRepository.getById(userDto.getStateId()));
        }
        user.setTimezoneMaster(timezoneRepository.getById(userDto.getTimezoneId()));
        user.setApplicationLocale(applicationLocaleRepository.getById(userDto.getApplicationLocaleId()));
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.getById(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        if (!userDto.getCountryId().equals(user.getCountryMaster().getId())) {
            user.setCountryMaster(countryMasterRepository.getById(userDto.getCountryId()));
        }
        if (user.getStateMaster()!=null && userDto.getStateId().equals(user.getStateMaster().getId())) {
            user.setStateMaster(userDto.getStateId()==null ? null : stateMasterRepository.getById(userDto.getStateId()));
        }
        if (!userDto.getTimezoneId().equals(user.getTimezoneMaster().getId())) {
            user.setTimezoneMaster(timezoneRepository.getById(userDto.getTimezoneId()));
        }
        if (!userDto.getApplicationLocaleId().equals(user.getApplicationLocale().getId())) {
            user.setApplicationLocale(applicationLocaleRepository.getById(userDto.getApplicationLocaleId()));
        }
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.getById(userId);
        user.setActiveflag(Boolean.FALSE);
        userRepository.save(user);
    }
}
