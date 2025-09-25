package com.project.blog.dto;

import java.time.LocalDateTime;

import com.project.blog.model.Comment;

public class CommentDTO {
    private Integer id;
    private String content;
    private int score;
    private LocalDateTime createdAt;
    private UserDTO user;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.score = comment.getScore();
        this.createdAt = comment.getCreatedAt();
        this.user = new UserDTO(comment.getUser());
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
}
