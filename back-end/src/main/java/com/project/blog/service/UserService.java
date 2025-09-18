package com.project.blog.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.UserRegistrationDto;
import com.project.blog.model.Role;
import com.project.blog.model.User;
import com.project.blog.repo.UserRepository;
import com.project.blog.repo.RoleRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(UserRegistrationDto userRegistrationDto) {
        Optional<User> exstistingUser = userRepository.findByUsername(userRegistrationDto.getUsername());

        if (exstistingUser.isPresent()) throw new IllegalArgumentException("Questo username è già stato preso!");

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
