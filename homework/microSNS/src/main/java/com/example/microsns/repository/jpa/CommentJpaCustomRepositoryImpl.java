package com.example.microsns.repository.jpa;

import com.example.microsns.domain.Comment;
import com.example.microsns.entity.CommentEntity;
import com.example.microsns.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
@RequiredArgsConstructor
public class CommentJpaCustomRepositoryImpl implements CommentRepository {

    private final CommentJpaRepository commentJpaRepository;
    private final BoardJpaRepository boardJpaRepository;
    private final MessageSource messageSource;

    @Override
    public List<Comment> findByBoardId(Long boardId) {
        return commentJpaRepository.findByBoardIdOrderByCreatedAt(boardId)
                .stream()
                .map(e -> e.toComment())
                .toList();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentJpaRepository.findById(id)
                .map(e -> e.toComment());
    }

    @Override
    public void save(Comment comment, Long boardId) {
        CommentEntity commentEntity = CommentEntity.fromComment(comment);
        commentEntity.setBoard(boardJpaRepository.findById(boardId).orElse(null));
        CommentEntity comment1 = commentJpaRepository.save(commentEntity);
        comment.setId(comment1.getId());
    }

    @Override
    public boolean update(Long id, String password, String newContent) {
        CommentEntity commentEntity = commentJpaRepository.findById(id).orElse(null);
        System.out.println("password : " + password);
        System.out.println("newContent : " + newContent);
        System.out.println(commentEntity.getPassword());
        if(commentEntity == null || !commentEntity.getPassword().equals(password)) {
            return false;
        }
        commentEntity.setContent(newContent);
        commentEntity.setModifiedAt(LocalDateTime.now());
        return true;
    }

    @Override
    public boolean delete(Long id, String password) {
        CommentEntity entity = commentJpaRepository.findById(id).orElse(null);
        if (entity == null || !entity.getPassword().equals(password)) {
            return false;
        }
        commentJpaRepository.delete(entity);
        return true;
    }
}
