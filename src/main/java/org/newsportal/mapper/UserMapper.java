package org.newsportal.mapper;

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
}
