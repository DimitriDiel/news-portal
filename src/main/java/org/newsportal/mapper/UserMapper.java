package org.newsportal.mapper;

import org.newsportal.dto.UserRequestDto;
import org.newsportal.dto.UserResponseDto;
import org.newsportal.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponseDto toResponse(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .city(user.getCity())
                .state(user.getState())
                .zip(user.getZip())
                .country(user.getCountry())
                .roles(user.getRoles())
                .build();
    }

    public User toUser(UserRequestDto request) {
        return User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .zip(request.getZip())
                .country(request.getCountry())
                .build();
    }
}
