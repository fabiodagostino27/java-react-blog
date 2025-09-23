package com.project.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByOrderByCreatedAtDesc();
    List<Post> findAllByOrderByCreatedAt();
}
