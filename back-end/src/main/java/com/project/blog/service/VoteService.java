package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.VoteCreationDTO;
import com.project.blog.model.Comment;
import com.project.blog.model.Post;
import com.project.blog.model.Reply;
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
        if (voteCreationDTO.getEntityType().equals("POST")) findOrCreatePostVote(user, voteCreationDTO);
        else if (voteCreationDTO.getEntityType().equals("COMMENT")) findOrCreateCommentVote(user, voteCreationDTO);
        else if (voteCreationDTO.getEntityType().equals("REPLY")) findOrCreateReplyVote(user, voteCreationDTO);
        else {
            throw new RuntimeException("Qualcosa è andato storto!");
        }
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
                post.setScore(post.getScore() + 1);
            } else {
                post.setScore(post.getScore() - 1);
            }
            voteRepository.save(vote);
            postRepository.save(post);
        }
    }

    public void findOrCreateCommentVote(User user, VoteCreationDTO voteCreationDTO) {
        Optional<Comment> commentAttempt = commentRepository.findById(voteCreationDTO.getEntityId());
        if (commentAttempt.isEmpty())
            throw new RuntimeException("Commento non trovato!");
        Comment comment = commentAttempt.get();
        if (user.equals(comment.getUser()))
            throw new RuntimeException("Non puoi votare il tuo stesso commento!");

        Optional<Vote> existingVote = voteRepository.findByUserAndComment(user, comment);
        if (existingVote.isPresent()) {
            if (existingVote.get().getType().equals(voteCreationDTO.getType())) {
                if (voteCreationDTO.getType().equals("UPVOTE")) {
                    comment.setScore(comment.getScore() - 1);
                } else { 
                    comment.setScore(comment.getScore() + 1);
                }
                commentRepository.save(comment);
                voteRepository.delete(existingVote.get());
            } else {
                if (voteCreationDTO.getType().equals("UPVOTE")) {
                    comment.setScore(comment.getScore() + 2);
                } else {
                    comment.setScore(comment.getScore() - 2);
                }
                existingVote.get().setType(voteCreationDTO.getType());
                voteRepository.save(existingVote.get());
                commentRepository.save(comment);
            }
        } else {
            Vote vote = new Vote();
            vote.setComment(comment);
            vote.setType(voteCreationDTO.getType());
            vote.setUser(user);

            if (voteCreationDTO.getType().equals("UPVOTE")) {
                comment.setScore(comment.getScore() + 1);
            } else {
                comment.setScore(comment.getScore() - 1);
            }
            voteRepository.save(vote);
            commentRepository.save(comment);
        }
    }

        public void findOrCreateReplyVote(User user, VoteCreationDTO voteCreationDTO) {
        Optional<Reply> replyAttempt = replyRepository.findById(voteCreationDTO.getEntityId());
        if (replyAttempt.isEmpty())
            throw new RuntimeException("Risposta non trovata!");
        Reply reply = replyAttempt.get();
        if (user.equals(reply.getUser()))
            throw new RuntimeException("Non puoi votare la tua stessa risposta!");
        
        Optional<Vote> existingVote = voteRepository.findByUserAndReply(user, reply);

        if (existingVote.isPresent()) {
            if (existingVote.get().getType().equals(voteCreationDTO.getType())) {
                if (voteCreationDTO.getType().equals("UPVOTE")) {
                    reply.setScore(reply.getScore() - 1);
                } else {
                    reply.setScore(reply.getScore() + 1);
                }
                replyRepository.save(reply);
                voteRepository.delete(existingVote.get());
            } else {
                if (voteCreationDTO.getType().equals("UPVOTE")) {
                    reply.setScore(reply.getScore() + 2);
                } else {
                    reply.setScore(reply.getScore() - 2);
                }
                existingVote.get().setType(voteCreationDTO.getType());
                voteRepository.save(existingVote.get());
                replyRepository.save(reply);
            }
        } else {
            Vote vote = new Vote();
            vote.setReply(reply);
            vote.setType(voteCreationDTO.getType());
            vote.setUser(user);
            
            if (voteCreationDTO.getType().equals("UPVOTE")) {
                reply.setScore(reply.getScore() + 1);
            } else {
                reply.setScore(reply.getScore() - 1);
            }
            
            voteRepository.save(vote);
            replyRepository.save(reply);
        }
    }
}
