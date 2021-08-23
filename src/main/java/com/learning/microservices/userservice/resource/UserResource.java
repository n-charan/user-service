package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.model.UserDto;
import com.learning.microservices.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String role) {
        List<UserDto> userList = userService.getAllUsers(active, role);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable(name = "id") Long userId) {
        UserDto user = userService.getUserDetails(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(
            @Valid @RequestBody UserDto userDto) {
        UserDto user = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name = "id") Long userId ,@Valid @RequestBody UserDto userDto) {
        userDto.setId(userId);
        UserDto user = userService.updateUser(userDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
