package com.project.blog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Optional<Vote> findByUserIdAndEntityIdAndEntityType(Integer userId, Integer entityId, String entityType);
}
