package com.project.blog.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.project.blog.model.Comment;
import com.project.blog.model.Reply;

public class CommentDTO {
    private Integer id;
    private String content;
    private int score;
    private LocalDateTime createdAt;
    private UserDTO user;
    private List<ReplyDTO> replies;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.score = comment.getScore();
        this.createdAt = comment.getCreatedAt();
        this.user = new UserDTO(comment.getUser());

        List<ReplyDTO> orderedList = new ArrayList<>();
        for (Reply reply : comment.getReplies()) {
            orderedList.add(new ReplyDTO(reply));
        }
        orderedList.sort(new Comparator<ReplyDTO>() {
            @Override
            public int compare(ReplyDTO r1, ReplyDTO r2) {
                return r1.getCreatedAt().compareTo(r2.getCreatedAt());
            }
        });
        this.replies = orderedList;
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

}
