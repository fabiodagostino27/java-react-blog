package com.project.blog.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

public class ReplyCreationDTO {
    @Lob
    @NotBlank(message = "The reply's content cnnot be null, empty or blank.")
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
