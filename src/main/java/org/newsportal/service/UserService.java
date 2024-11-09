package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.dto.UserRequestDto;
import org.newsportal.dto.UserResponseDto;
import org.newsportal.entity.User;
import org.newsportal.exception.NotFoundException;
import org.newsportal.mapper.UserMapper;
import org.newsportal.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto registerUser(UserRequestDto request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.getRoleUser()));
        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

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

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getPrincipal().toString();
        Optional<User> optionalUser = getUserByEmail(userName);
        return optionalUser.orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new NotFoundException("User with id " + userId + " not found");
        }
    }

}
