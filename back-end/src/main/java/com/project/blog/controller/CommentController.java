package com.project.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.dto.CommentCreationDTO;
import com.project.blog.service.CommentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/{id}/create")
    public ResponseEntity<?> create(@PathVariable Integer id, @Valid @RequestBody CommentCreationDTO commentCreationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        
        try {
            commentService.create(id, commentCreationDTO);
            return new ResponseEntity<>("Commento creato con successo", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
