package com.example.microsns.jdbc.service;

import com.example.microsns.CommentRepository;
import com.example.microsns.jdbc.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    public void save(Comment comment, Long boardId) {
        commentRepository.save(comment, boardId);
    }

    public boolean updateComment(Long id, String password, String content) {
        return commentRepository.update(id, password, content);
    }

    public boolean deleteComment(Long id, String password) {
        return commentRepository.delete(id, password);
    }

    public Optional<Comment> findById(Long id2) {
        return commentRepository.findById(id2);
    }
}
