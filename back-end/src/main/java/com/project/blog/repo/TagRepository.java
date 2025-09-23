package com.project.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
