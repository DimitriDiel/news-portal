package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.entity.Role;
import org.newsportal.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleUser(){
        return roleRepository.findByTitle("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("No role found"));
    }
}
