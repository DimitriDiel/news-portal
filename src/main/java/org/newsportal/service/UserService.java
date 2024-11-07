package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
