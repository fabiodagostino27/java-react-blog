package com.project.blog.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.dto.CommentDTO;
import com.project.blog.dto.PostDTO;
import com.project.blog.dto.ReplyDTO;
import com.project.blog.model.Comment;
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
            if (existingVote.isPresent())
                postVoteType = existingVote.get().getType();
        }

        PostDTO postDTO = new PostDTO(post, postVoteType);
        for (Comment comment : post.getComments()) {
            postDTO.getComments().add(mapCommentToDTO(comment, user));
        }
        return postDTO;
    }

    public CommentDTO mapCommentToDTO(Comment comment, User user) {
        String commentVoteType = null;

        if (user != null) {
            Optional<Vote> existingVote = voteRepository.findByUserAndComment(user, comment);
            if (existingVote.isPresent())
                commentVoteType = existingVote.get().getType();
        }

        CommentDTO commentDTO = new CommentDTO(comment, commentVoteType);
        List<ReplyDTO> orderedList = new ArrayList<>();
        for (Reply reply : comment.getReplies()) {
            orderedList.add(mapReplyToDTO(reply, user));
        }
        orderedList.sort(new Comparator<ReplyDTO>() {
            @Override
            public int compare(ReplyDTO r1, ReplyDTO r2) {
                return r1.getCreatedAt().compareTo(r2.getCreatedAt());
            }
        });
        commentDTO.setReplies(orderedList);
        return commentDTO;
    }

    public ReplyDTO mapReplyToDTO(Reply reply, User user) {
        String replyVoteType = null;

        if (user != null) {
            Optional<Vote> existingVote = voteRepository.findByUserAndReply(user, reply);
            if (existingVote.isPresent())
                replyVoteType = existingVote.get().getType();
        }

        return new ReplyDTO(reply, replyVoteType);
    }
}
