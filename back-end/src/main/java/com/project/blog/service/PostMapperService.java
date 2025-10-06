package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.dto.PostDTO;
import com.project.blog.dto.ReplyDTO;
import com.project.blog.model.Post;
import com.project.blog.model.Reply;
import com.project.blog.model.User;
import com.project.blog.model.Vote;
import com.project.blog.repo.VoteRepository;

@Service
public class PostMapperService {
    @Autowired
    private VoteRepository voteRepository;

    public PostDTO mapPostToDTO(Post post, User user) {
        String postVoteType = null;

        if (user != null) {
            Optional<Vote> existingVote = voteRepository.findByUserAndPost(user, post);
            if (existingVote.isPresent()) postVoteType = existingVote.get().getType();
        }

        PostDTO postDTO = new PostDTO(post, postVoteType);


    }

    public ReplyDTO mapReplyToDTO(Reply reply, User user) {
        String replyVoteType = null;

        if (user != null) {
            Optional<Vote> existingVote = voteRepository.findByUserAndReply(user, reply);
            if (existingVote.isPresent()) replyVoteType = existingVote.get().getType();
        }

        return new ReplyDTO(reply, replyVoteType);
    }
}
