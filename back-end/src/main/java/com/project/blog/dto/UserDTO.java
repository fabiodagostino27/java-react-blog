package com.project.blog.dto;

import com.project.blog.model.User;

public class UserDTO {
    private Integer id;
    private String username;
    private String pfpPath;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.pfpPath = user.getPfpPath();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPfpPath() {
        return this.pfpPath;
    }

    public void setPfpPath(String pfpPath) {
        this.pfpPath = pfpPath;
    }
}
