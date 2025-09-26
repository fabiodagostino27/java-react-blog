package com.project.blog.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

public class CommentCreationDTO {
    @Lob
    @NotBlank(message = "The comment text content cannot be blank, empty or null.")
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
