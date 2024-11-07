package org.newsportal.repository;

import org.newsportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long userId);
    Optional<User>deleteUserById(Long userId);
}
