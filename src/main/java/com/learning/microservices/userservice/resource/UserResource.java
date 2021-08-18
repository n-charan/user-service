package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.model.UserDto;
import com.learning.microservices.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/users")
public class UserResource {

    private final UserService userService;

    UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(required = false) Boolean activeflag,
            @RequestParam(required = false) String role) {
        List<UserDto> userList = userService.getAllUsers(activeflag, role);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable(name = "id") Long userId) {
        UserDto user = userService.getUserDetails(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(
            @RequestBody UserDto userDto) {
        UserDto user = userService.saveUser(userDto);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto) {
        UserDto user = userService.updateUser(userDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
