package com.project.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.dto.PostCreationDTO;
import com.project.blog.model.Post;
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
        Optional<Post> postAttempt = postService.findById(id);
        if (postAttempt.isEmpty()) return new ResponseEntity<>("Post non trovato!", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(postAttempt.get(), HttpStatus.OK);
    }
    

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PostCreationDTO postCreationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        
        try {
            postService.create(postCreationDTO);
            return new ResponseEntity<>("Post creato con successo", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
