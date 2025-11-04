package com.project.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.dto.PostCreationDTO;
import com.project.blog.dto.SimplePostDTO;
import com.project.blog.service.PostService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<SimplePostDTO>> indexRecent(Pageable pageable) {
        Sort sort = pageable.getSort();
        boolean isDateDesc = false;

        if (sort.isSorted()) {
            for (Sort.Order order : sort) {
                if (order.getProperty().equals("createdAt") && order.getDirection().isDescending()) {
                    isDateDesc = true;
                    break;
                }
            }
        }

        if (sort.isUnsorted() || isDateDesc) {
            return new ResponseEntity<>(postService.findNewest(pageable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(postService.findOldest(pageable), HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PostCreationDTO postCreationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);

        try {
            postService.create(postCreationDTO);
            return new ResponseEntity<>("Post creato con successo", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
