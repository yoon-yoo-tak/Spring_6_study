package com.example.microsns;

import com.example.microsns.jdbc.domain.Board;

import java.util.List;

public interface BoardRepository {
    void save(Board board);
    Board findById(Long id);
    List<Board> findAll();
    void update(Board board);
    void delete(Long id);
    List<Board> findRecent(int limit);
    List<Board> findOlderThan(Long lastId, int limit);
}
