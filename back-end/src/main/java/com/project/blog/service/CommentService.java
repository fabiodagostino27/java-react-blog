package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.CommentCreationDTO;
import com.project.blog.model.Comment;
import com.project.blog.model.Post;
import com.project.blog.model.User;
import com.project.blog.repo.CommentRepository;
import com.project.blog.repo.PostRepository;
import com.project.blog.repo.UserRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment create(Integer postId, CommentCreationDTO commentCreationDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if (userAttempt.isEmpty()) throw new RuntimeException("User non trovato.");
        Optional<Post> postAttempt = postRepository.findById(postId);
        if (postAttempt.isEmpty()) throw new RuntimeException("Post non trovato");
        Comment comment = new Comment();
        comment.setUser(userAttempt.get());
        comment.setPost(postAttempt.get());
        comment.setScore(0);
        comment.setContent(commentCreationDTO.getContent());
        return commentRepository.save(comment);
    }     
}
