package com.project.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
