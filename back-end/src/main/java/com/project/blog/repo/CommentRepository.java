package com.project.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
