package com.project.blog.dto;

import java.util.List;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

public class PostCreationDTO {
    @NotBlank(message = "The username cannot be blank, empty or null.")
    private String title;

    @Lob
    @NotBlank(message = "The post text content cannot be blank, empty or null.")
    private String textContent;

    private String imgPath;

    private List<Integer> tagIds;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Integer> getTagIds() {
        return this.tagIds;
    }

    public void setTagIds(List<Integer> tagIds) {
        this.tagIds = tagIds;
    }
}
