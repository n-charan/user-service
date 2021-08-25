package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.model.UserRequestDto;
import com.learning.microservices.userservice.model.UserResponseDto;
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
    public ResponseEntity<List<UserResponseDto>> getAllUsers(
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String role) {
        List<UserResponseDto> userList = userService.getAllUsers(active, role);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserDetails(@PathVariable(name = "id") Long userId) {
        UserResponseDto user = userService.getUserDetails(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(
            @Valid @RequestBody UserRequestDto userDto) {
        UserResponseDto user = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable(name = "id") Long userId ,@Valid @RequestBody UserRequestDto userDto) {
        userDto.setId(userId);
        UserResponseDto user = userService.updateUser(userDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
