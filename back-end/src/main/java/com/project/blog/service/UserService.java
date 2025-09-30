package com.project.blog.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Optional<User> exsistingUser = userRepository.findByUsername(userRegistrationDto.getUsername());

        if (exsistingUser.isPresent())
            throw new IllegalArgumentException("Questo username è già stato preso!");

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setPfpPath(
                "https://static.vecteezy.com/system/resources/thumbnails/020/765/399/small/default-profile-account-unknown-icon-black-silhouette-free-vector.jpg");

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public User updatePfp(String pfpPath) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if (userAttempt.isEmpty()) {
            throw new RuntimeException("User non trovato.");
        }
        User user = userAttempt.get();
        user.setPfpPath(pfpPath);
        return userRepository.save(user);
    }
}
