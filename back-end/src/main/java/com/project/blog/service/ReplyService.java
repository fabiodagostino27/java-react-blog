package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.ReplyCreationDTO;
import com.project.blog.model.Comment;
import com.project.blog.model.Reply;
import com.project.blog.model.User;
import com.project.blog.repo.CommentRepository;
import com.project.blog.repo.ReplyRepository;
import com.project.blog.repo.UserRepository;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public Reply create(Integer commentId, ReplyCreationDTO replyCreationDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if (userAttempt.isEmpty()) throw new RuntimeException("User non trovato.");
        Optional<Comment> commentAttempt = commentRepository.findById(commentId);
        if (commentAttempt.isEmpty()) throw new RuntimeException("Commento non trovato.");
        Reply reply = new Reply();
        reply.setUser(userAttempt.get());
        reply.setComment(commentAttempt.get());
        reply.setScore(0);
        reply.setContent(replyCreationDTO.getContent());
        return replyRepository.save(reply);
    }
}
