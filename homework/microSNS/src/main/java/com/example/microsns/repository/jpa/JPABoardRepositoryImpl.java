package com.example.microsns.repository.jpa;

import com.example.microsns.domain.Board;
import com.example.microsns.entity.BoardEntity;
import com.example.microsns.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Profile("jpa")
@Repository
@RequiredArgsConstructor
public class JPABoardRepositoryImpl implements BoardRepository {

    private final JPABoardRepository jpaBoardRepository;

    @Override
    public void save(Board board) throws SQLException {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(board.getTitle());
        entity.setContent(board.getContent());
        entity.setWriter(board.getWriter());
        entity.setPassword(board.getPassword());
        entity.setCreatedAt(board.getCreatedAt());
        entity.setModifiedAt(board.getModifiedAt());
        jpaBoardRepository.save(entity);
    }

    @Override
    public Board findById(Long id) {
        return jpaBoardRepository.findById(id)
                .map(e -> e.toBoard())
                .orElse(null);
    }

    @Override
    public List<Board> findAll() {
        return jpaBoardRepository.findAll()
                .stream()
                .map(e -> e.toBoard())
                .toList();
    }

    @Override
    public void update(Board board) {
        BoardEntity boardEntity = jpaBoardRepository.findById(board.getId()).orElse(null);
        boardEntity.setTitle(board.getTitle());
        boardEntity.setContent(board.getContent());
    }

    @Override
    public void delete(Long id) {
        jpaBoardRepository.deleteById(id);
    }

    @Override
    public List<Board> findRecent(int limit) {
        return jpaBoardRepository.findAllByOrderByIdDesc(PageRequest.of(0, limit))
                .stream()
                .map(entity -> entity.toBoard())
                .toList();
    }

    @Override
    public List<Board> findOlderThan(Long lastId, int limit) {
        return jpaBoardRepository.findByIdLessThanOrderByIdDesc(lastId, PageRequest.of(0, limit))
                .stream()
                .map(entity -> entity.toBoard())
                .toList();
    }
}
