package com.example.microsns.repository.springjdbc;

import com.example.microsns.repository.BoardRepository;
import com.example.microsns.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("springjdbc") // 프로파일은 springjdbc로 따로 분리
public class JdbcTemplateBoardRepository implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Board board) {
        String sql = "INSERT INTO board (title, content, writer, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getWriter(), board.getPassword());
    }

    @Override
    public Board findById(Long id) {
        String sql = "SELECT * FROM board WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, boardRowMapper(), id);
    }

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM board ORDER BY id DESC";
        return jdbcTemplate.query(sql, boardRowMapper());
    }

    @Override
    public void update(Board board) {
        String sql = "UPDATE board SET title = ?, content = ?, modified_at = NOW() WHERE id = ? AND password = ?";
        jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getId(), board.getPassword());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM board WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Board> findRecent(int limit) {
        String sql = "SELECT * FROM board ORDER BY id DESC LIMIT ?";
        return jdbcTemplate.query(sql, boardRowMapper(), limit);
    }

    @Override
    public List<Board> findOlderThan(Long lastId, int limit) {
        String sql = "SELECT * FROM board WHERE id < ? ORDER BY id DESC LIMIT ?";
        return jdbcTemplate.query(sql, boardRowMapper(), lastId, limit);
    }

    private RowMapper<Board> boardRowMapper() {
        return (rs, rowNum) -> {
            Board board = new Board();
            board.setId(rs.getLong("id"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setPassword(rs.getString("password"));
            board.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            if (rs.getTimestamp("modified_at") != null) {
                board.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
            }
            return board;
        };
    }
}
