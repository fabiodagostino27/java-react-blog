package com.project.blog.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.project.blog.model.Comment;

public class CommentDTO {
    private Integer id;
    private String content;
    private int score;
    private LocalDateTime createdAt;
    private String currentUserVoteType;
    private UserDTO user;
    private List<ReplyDTO> replies = new ArrayList<>();

    public CommentDTO(Comment comment, String voteType) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.score = comment.getScore();
        this.createdAt = comment.getCreatedAt();
        this.user = new UserDTO(comment.getUser());
        this.currentUserVoteType = voteType;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserDTO getUser() {
        return this.user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ReplyDTO> getReplies() {
        return this.replies;
    }

    public void setReplies(List<ReplyDTO> replies) {
        this.replies = replies;
    }

    public String getCurrentUserVoteType() {
        return this.currentUserVoteType;
    }

    public void setCurrentUserVoteType(String currentUserVoteType) {
        this.currentUserVoteType = currentUserVoteType;
    }

}
