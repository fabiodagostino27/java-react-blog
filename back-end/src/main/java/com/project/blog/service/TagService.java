package com.project.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.dto.TagDTO;
import com.project.blog.model.Tag;
import com.project.blog.repo.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public TagDTO findById(Integer id) {
        Optional<Tag> tagAttempt = tagRepository.findById(id);
        if (tagAttempt.isEmpty()) throw new RuntimeException("Tag non trovato.");
        return new TagDTO(tagAttempt.get());
    }
}
