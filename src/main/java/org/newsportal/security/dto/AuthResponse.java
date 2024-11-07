package org.newsportal.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.newsportal.dto.UserResponseDto;

@Data
@AllArgsConstructor
public class AuthResponse {

    private TokenResponseDto token;
    private UserResponseDto user;
}
