package com.example.microsns.service;

import com.example.microsns.repository.CommentRepository;
import com.example.microsns.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    @Transactional
    public void save(Comment comment, Long boardId) {
        commentRepository.save(comment, boardId);
    }

    @Transactional
    public boolean updateComment(Long id, String password, String content) {

        return commentRepository.update(id, password, content);
    }
    @Transactional
    public boolean deleteComment(Long id, String password) {
        return commentRepository.delete(id, password);
    }

    public Optional<Comment> findById(Long id2) {
        return commentRepository.findById(id2);
    }
}
