package com.example.microsns;

import com.example.microsns.jdbc.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    List<Comment> findByBoardId(Long boardId);
    Optional<Comment> findById(Long id);
    void save(Comment comment, Long boardId);
    boolean update(Long id, String password, String newContent);
    boolean delete(Long id, String password);
}
