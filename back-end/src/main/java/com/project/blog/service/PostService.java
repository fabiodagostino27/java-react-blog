package com.project.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.blog.dto.PostCreationDTO;
import com.project.blog.model.Post;
import com.project.blog.model.User;
import com.project.blog.repo.PostRepository;
import com.project.blog.repo.TagRepository;
import com.project.blog.repo.UserRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public List<Post> findNewest() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Post> findOldest() {
        return postRepository.findAllByOrderByCreatedAt();
    }

    public Post create(PostCreationDTO postCreationDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if (userAttempt.isEmpty()) {
            throw new RuntimeException("User non trovato.");
        }
        Post post = new Post();
        post.setUser(userAttempt.get());
        post.setTitle(postCreationDTO.getTitle());
        post.setTextContent(postCreationDTO.getTextContent());
        post.setImgPath(postCreationDTO.getImgPath());
        post.setTags(tagRepository.findAllById(postCreationDTO.getTagIds()));
        post.setScore(0);
        return postRepository.save(post);
    }
}
