package com.example.microsns.repository;

import com.example.microsns.domain.Board;

import java.sql.SQLException;
import java.util.List;

public interface BoardRepository {
    void save(Board board) throws SQLException;
    Board findById(Long id);
    List<Board> findAll();
    void update(Board board);
    void delete(Long id);
    List<Board> findRecent(int limit);
    List<Board> findOlderThan(Long lastId, int limit);
}
