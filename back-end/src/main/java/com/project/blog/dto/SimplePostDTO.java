package com.project.blog.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.project.blog.model.Post;
import com.project.blog.model.Tag;

public class SimplePostDTO {
    private Integer id;
    private String title;
    private String imgPath;
    private int score;
    private LocalDateTime createdAt;
    private UserDTO user;
    private int commentsCount;
    private List<Tag> tags;

    public SimplePostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.imgPath = post.getImgPath();
        this.score = post.getScore();
        this.createdAt = post.getCreatedAt();
        this.user = new UserDTO(post.getUser());
        this.commentsCount = post.getComments().size();
        this.tags = new ArrayList<>();

        for (Tag tag : post.getTags()) {
            tags.add(tag);
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public int getCommentsCount() {
        return this.commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
