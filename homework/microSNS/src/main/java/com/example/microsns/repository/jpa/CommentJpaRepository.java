package com.example.microsns.repository.jpa;

import com.example.microsns.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByBoardIdOrderByCreatedAt(Long boardId);
}
