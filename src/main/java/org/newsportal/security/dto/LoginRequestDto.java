package org.newsportal.security.dto;

public record LoginRequestDto(
        String username,
        String password) {
}
