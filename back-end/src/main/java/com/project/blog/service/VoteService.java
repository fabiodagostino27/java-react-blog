package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.VoteCreationDTO;
import com.project.blog.model.Post;
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
        if (userAttempt.isEmpty())
            throw new RuntimeException("User non trovato.");
        User user = userAttempt.get();
    }

    public void findOrCreatePostVote(User user, VoteCreationDTO voteCreationDTO) {
        Optional<Post> postAttempt = postRepository.findById(voteCreationDTO.getEntityId());
        if (postAttempt.isEmpty())
            throw new RuntimeException("Post non trovato!");
        Post post = postAttempt.get();
        if (user.equals(post.getUser()))
            throw new RuntimeException("Non puoi votare il tuo stesso post!");
        Optional<Vote> existingVote = voteRepository.findByUserAndPost(user, postAttempt.get());
        if (existingVote.isPresent()) {
            if (existingVote.get().getType().equals(voteCreationDTO.getType())) {
                if (voteCreationDTO.getType().equals("UPVOTE")) {
                    post.setScore(post.getScore() - 1);
                } else {
                    post.setScore(post.getScore() + 1);
                }
                postRepository.save(post);
                voteRepository.delete(existingVote.get());
            } else {
                if (voteCreationDTO.getType().equals("UPVOTE")) {
                    post.setScore(post.getScore() + 2);
                } else {
                    post.setScore(post.getScore() - 2);
                }
                existingVote.get().setType(voteCreationDTO.getType());
                voteRepository.save(existingVote.get());
                postRepository.save(post);
            }
        } else {
            Vote vote = new Vote();
            vote.setPost(post);
            vote.setType(voteCreationDTO.getType());
            vote.setUser(user);
            if (voteCreationDTO.getType().equals("UPVOTE")) {
                post.setScore(post.getScore() - 1);
            } else {
                post.setScore(post.getScore() + 1);
            }
            voteRepository.save(vote);
            postRepository.save(post);
        }
    }
}
