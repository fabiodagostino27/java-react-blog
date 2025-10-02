package com.project.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.dto.VoteCreationDTO;
import com.project.blog.service.VoteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/api/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<?> applyVote(@Valid @RequestBody VoteCreationDTO voteCreationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        
        try {
            voteService.applyVote(voteCreationDTO);
            return new ResponseEntity<>("Voto aggiunto con successo!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
