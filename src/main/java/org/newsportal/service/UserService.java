package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.dto.UserResponseDto;
import org.newsportal.entity.User;
import org.newsportal.mapper.UserMapper;
import org.newsportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserResponseDto getUserProfileByEmail(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            User u = user.get();
            return userMapper.toResponse(u);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
