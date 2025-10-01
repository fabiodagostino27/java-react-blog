package com.project.blog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Comment;
import com.project.blog.model.Post;
import com.project.blog.model.Reply;
import com.project.blog.model.User;
import com.project.blog.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Optional<Vote> findByUserAndPost(User user, Post post);
    Optional<Vote> findByUserAndComment(User user, Comment comment);
    Optional<Vote> findByUserAndReply(User user, Reply reply);
}
