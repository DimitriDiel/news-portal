package org.newsportal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.newsportal.dto.UserRequestDto;
import org.newsportal.dto.UserResponseDto;
import org.newsportal.exception.InvalidDataException;
import org.newsportal.exception.NotFoundException;
import org.newsportal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        if (userRequestDto.getEmail() == null) {
            throw new InvalidDataException("Invalid email address.");
        }
        return ResponseEntity.ok(userService.registerUser(userRequestDto));
    }

    @GetMapping
    ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.findAllUsers();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found.");
        }
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<UserResponseDto> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
