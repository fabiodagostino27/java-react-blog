package com.project.blog.dto;

import java.time.LocalDateTime;

import com.project.blog.model.Reply;

public class ReplyDTO {
    private Integer id;
    private String content;
    private int score;
    private LocalDateTime createdAt;
    private String currentUserVoteType;
    private UserDTO user;

    public ReplyDTO(Reply reply, String voteType) {
        this.id = reply.getId();
        this.content = reply.getContent();
        this.score = reply.getScore();
        this.createdAt = reply.getCreatedAt();
        this.user = new UserDTO(reply.getUser());
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

    public String getCurrentUserVoteType() {
        return this.currentUserVoteType;
    }

    public void setCurrentUserVoteType(String currentUserVoteType) {
        this.currentUserVoteType = currentUserVoteType;
    }

}
