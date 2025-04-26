package com.example.microsns.repository.jpa;

import com.example.microsns.domain.Comment;
import com.example.microsns.entity.CommentEntity;
import com.example.microsns.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
@RequiredArgsConstructor
public class JPACommentRepositoryImpl implements CommentRepository {

    private final JPACommentRepository jpaCommentRepository;
    private final JPABoardRepository boardRepository;


    @Override
    public List<Comment> findByBoardId(Long boardId) {
        return jpaCommentRepository.findByBoardIdOrderByCreatedAt(boardId)
                .stream()
                .map(e -> e.toComment())
                .toList();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return jpaCommentRepository.findById(id)
                .map(e -> e.toComment());
    }

    @Override
    public void save(Comment comment, Long boardId) {
        CommentEntity commentEntity = CommentEntity.fromComment(comment);
        commentEntity.setBoardEntity(boardRepository.findById(boardId).orElse(null));
        jpaCommentRepository.save(commentEntity);
    }

    @Override
    public boolean update(Long id, String password, String newContent) {
        CommentEntity commentEntity = jpaCommentRepository.findById(id).orElse(null);
        if(commentEntity == null || !commentEntity.getPassword().equals(password)) {
            return false;
        }
        commentEntity.setContent(newContent);
        commentEntity.setModifiedAt(LocalDateTime.now());
        return true;
    }

    @Override
    public boolean delete(Long id, String password) {
        CommentEntity entity = jpaCommentRepository.findById(id).orElse(null);
        if (entity == null || !entity.getPassword().equals(password)) {
            return false;
        }
        jpaCommentRepository.delete(entity);
        return true;
    }
}
