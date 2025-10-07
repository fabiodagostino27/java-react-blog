package com.project.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
