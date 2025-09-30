package com.project.blog.dto;

import jakarta.validation.constraints.NotBlank;

public class PfpUpdateRequestDTO {
    @NotBlank(message = "The profile picture's image path cannot be empty, null or blank.")
    private String pfpPath;

    public String getPfpPath() {
        return this.pfpPath;
    }

    public void setPfpPath(String pfpPath) {
        this.pfpPath = pfpPath;
    }
}
