package com.project.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VoteCreationDTO {
    @NotNull(message = "The entity id cannot be null.")
    private Integer entityId;

    @NotBlank(message = "The entity type cannot be blank, null or empty")
    private String entityType;

    @NotBlank(message = "The vote type cannot be blank, null or empty")
    private String type;

    public Integer getEntityId() {
        return this.entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
