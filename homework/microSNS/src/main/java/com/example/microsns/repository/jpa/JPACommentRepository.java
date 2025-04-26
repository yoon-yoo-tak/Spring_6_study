package com.example.microsns.repository.jpa;

import com.example.microsns.domain.Comment;
import com.example.microsns.entity.CommentEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Profile("jpa")
public interface JPACommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByBoardIdOrderByCreatedAt(Long boardId);
}
