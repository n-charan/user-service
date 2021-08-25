package com.learning.microservices.userservice.service;

import com.learning.microservices.userservice.entity.CountryMaster;
import com.learning.microservices.userservice.entity.User;
import com.learning.microservices.userservice.exception.ResourceNotFoundException;
import com.learning.microservices.userservice.mapper.UserMapper;
import com.learning.microservices.userservice.model.UserRequestDto;
import com.learning.microservices.userservice.model.UserResponseDto;
import com.learning.microservices.userservice.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CountryMasterRepository countryMasterRepository;

    private final StateMasterRepository stateMasterRepository;

    private final TimezoneRepository timezoneRepository;

    private final ApplicationLocaleRepository applicationLocaleRepository;

    private final UserMapper userMapper;

    private final RoleRepository roleRepository;

    UserService(UserRepository userRepository,
                UserMapper userMapper,
                CountryMasterRepository countryMasterRepository,
                StateMasterRepository stateMasterRepository,
                TimezoneRepository timezoneRepository,
                ApplicationLocaleRepository applicationLocaleRepository,
                RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.countryMasterRepository = countryMasterRepository;
        this.stateMasterRepository = stateMasterRepository;
        this.timezoneRepository = timezoneRepository;
        this.applicationLocaleRepository = applicationLocaleRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserResponseDto> getAllUsers(Boolean active, String role) {
        List<User> userList = userRepository.findAll();
        if (active != null) {
            userList = userList.stream().filter(user -> user.getActiveflag().equals(active)).collect(Collectors.toList());
        }
        if (role != null) {
            userList = userList.stream().filter(user -> user.getRole().getCode().equals(role)).collect(Collectors.toList());
        }
        List<UserResponseDto> userDtoList = userList.stream().map(user ->
                userMapper.toDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    public UserResponseDto getUserDetails(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        return userMapper.toDto(userOptional.get());
    }

    public UserResponseDto saveUser(UserRequestDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        CountryMaster countryMaster = countryMasterRepository.findByISO(userDto.getCountryISO());
        user.setCountryMaster(countryMaster);
        if(StringUtils.hasLength(userDto.getStateCode())) {
            user.setStateMaster(stateMasterRepository.findByCountryMasterIdAndCode(countryMaster.getId(), userDto.getStateCode()));
        }
        user.setTimezoneMaster(timezoneRepository.findByCode(userDto.getTimezoneCode()));
        user.setApplicationLocale(applicationLocaleRepository.findByLocale(userDto.getAppLocale()));
        user.setRole(roleRepository.findByCode(userDto.getRoleCode()));
        user.setActiveflag(Boolean.TRUE);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponseDto updateUser(UserRequestDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        User user = userOptional.get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        CountryMaster countryMaster = user.getCountryMaster();
        if (!userDto.getCountryISO().equals(countryMaster.getISO())) {
            countryMaster = countryMasterRepository.findByISO(userDto.getCountryISO());
            user.setCountryMaster(countryMaster);
        }
        if (StringUtils.hasLength(userDto.getStateCode())
                && (user.getStateMaster() == null || !userDto.getStateCode().equals(user.getStateMaster().getCode()))) {
            user.setStateMaster(userDto.getStateCode()==null
                    ? null
                    : stateMasterRepository.findByCountryMasterIdAndCode(countryMaster.getId(), userDto.getStateCode()));
        }
        if (!userDto.getTimezoneCode().equals(user.getTimezoneMaster().getCode())) {
            user.setTimezoneMaster(timezoneRepository.findByCode(userDto.getTimezoneCode()));
        }
        if (!userDto.getAppLocale().equals(user.getApplicationLocale().getLocale())) {
            user.setApplicationLocale(applicationLocaleRepository.findByLocale(userDto.getAppLocale()));
        }
        if (!userDto.getRoleCode().equals(user.getRole().getCode())) {
            user.setRole(roleRepository.findByCode(userDto.getRoleCode()));
        }
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        User user = userOptional.get();
        user.setActiveflag(Boolean.FALSE);
        userRepository.save(user);
    }
}
