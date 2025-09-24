package com.project.blog.dto;

import java.time.LocalDateTime;

public class PostDTO {
    private Integer id;
    private String title;
    private String textContent;
    private String imgPath;
    private int score;
    private LocalDateTime createdAt;
    private UserDTO user;
    
}
