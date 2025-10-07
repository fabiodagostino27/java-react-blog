package com.project.blog.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.blog.model.Post;
import com.project.blog.model.Tag;

public class TagDTO {
    private Integer id;
    private String name;
    private String color;
    private List<SimplePostDTO> posts;

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
        this.color = tag.getColor();
        this.posts = new ArrayList<>();
        
        for (Post post : tag.getPosts()) {
            posts.add(new SimplePostDTO(post));
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<SimplePostDTO> getPosts() {
        return this.posts;
    }

    public void setPosts(List<SimplePostDTO> posts) {
        this.posts = posts;
    }

}
