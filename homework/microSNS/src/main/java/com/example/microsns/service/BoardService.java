package com.example.microsns.service;

import com.example.microsns.repository.BoardRepository;
import com.example.microsns.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    public void create(Board board) throws SQLException {
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public void update(Board board){
        boardRepository.update(board);
    }

    @Transactional
    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public List<Board> findRecent(int limit) {
        return boardRepository.findRecent(limit);
    }

    public List<Board> findOlderThan(Long lastId, int limit) {
        return boardRepository.findOlderThan(lastId, limit);
    }

}
