package com.example.microsns.repository.springjdbc;

import com.example.microsns.repository.CommentRepository;
import com.example.microsns.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("springjdbc")
public class JdbcTemplateCommentRepository implements CommentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> findByBoardId(Long boardId) {
        String sql = "SELECT * FROM comment WHERE board_id = ? ORDER BY created_at";
        return jdbcTemplate.query(sql, commentRowMapper(), boardId);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        String sql = "SELECT * FROM comment WHERE id = ?";
        List<Comment> result = jdbcTemplate.query(sql, commentRowMapper(), id);
        return result.stream().findFirst();
    }

    @Override
    public void save(Comment comment, Long boardId) {
        if (comment.getWriter() == null) {
            throw new IllegalArgumentException("작성자는 빈 값일 수 없습니다.");
        }
        String sql = "INSERT INTO comment (board_id, writer, content, password, created_at) VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, boardId);
            ps.setString(2, comment.getWriter());
            ps.setString(3, comment.getContent());
            ps.setString(4, comment.getPassword());
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            comment.setId(keyHolder.getKey().longValue());
        }
    }

    @Override
    public boolean update(Long id, String password, String newContent) {
        String sql = "UPDATE comment SET content = ?, modified_at = NOW() WHERE id = ? AND password = ?";
        int updated = jdbcTemplate.update(sql, newContent, id, password);
        return updated > 0;
    }

    @Override
    public boolean delete(Long id, String password) {
        String sql = "DELETE FROM comment WHERE id = ? AND password = ?";
        int deleted = jdbcTemplate.update(sql, id, password);
        return deleted > 0;
    }

    private RowMapper<Comment> commentRowMapper() {
        return (rs, rowNum) -> {
            Comment comment = new Comment();
            comment.setId(rs.getLong("id"));
            comment.setBoardId(rs.getLong("board_id"));
            comment.setWriter(rs.getString("writer"));
            comment.setContent(rs.getString("content"));
            comment.setPassword(rs.getString("password"));
            comment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            Timestamp modified = rs.getTimestamp("modified_at");
            if (modified != null) {
                comment.setModifiedAt(modified.toLocalDateTime());
            }
            return comment;
        };
    }
}
