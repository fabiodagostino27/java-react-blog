package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.VoteCreationDTO;
import com.project.blog.model.User;
import com.project.blog.model.Vote;
import com.project.blog.repo.CommentRepository;
import com.project.blog.repo.PostRepository;
import com.project.blog.repo.ReplyRepository;
import com.project.blog.repo.UserRepository;
import com.project.blog.repo.VoteRepository;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReplyRepository replyRepository;

    public void applyVote(VoteCreationDTO voteCreationDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if (userAttempt.isEmpty()) {
            throw new RuntimeException("User non trovato.");
        }
        Optional<Vote> voteAttempt = voteRepository.findByUserIdAndEntityIdAndEntityType(
                userAttempt.get().getId(),
                voteCreationDTO.getEntityId(),
                voteCreationDTO.getEntityType());
        if (voteAttempt.isPresent()) {
            if (voteCreationDTO.getType().equals(voteAttempt.get().getType())) {
            }
        }
    }
}
