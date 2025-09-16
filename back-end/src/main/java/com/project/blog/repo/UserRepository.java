package com.project.blog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findbyUsername(String username);
}
