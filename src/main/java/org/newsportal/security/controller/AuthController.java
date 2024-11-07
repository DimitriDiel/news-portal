package org.newsportal.security.controller;

import jakarta.security.auth.message.AuthException;
import org.newsportal.dto.UserResponseDto;
import org.newsportal.security.dto.AuthResponse;
import org.newsportal.security.dto.LoginRequestDto;
import org.newsportal.security.dto.RefreshRequestDto;
import org.newsportal.security.dto.TokenResponseDto;
import org.newsportal.security.service.AuthService;
import org.newsportal.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            return authService.login(loginRequestDto);
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/refresh")
    public TokenResponseDto refreshAccessToken(@RequestBody RefreshRequestDto refreshRequestDto) {

        try {
            return authService.refreshAccessToken(refreshRequestDto);
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/profile")
    public UserResponseDto getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();

        return userService.getUserProfileByEmail(username);

    }
}
