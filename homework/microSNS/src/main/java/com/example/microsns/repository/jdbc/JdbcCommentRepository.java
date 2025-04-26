package com.example.microsns.repository.jdbc;

import com.example.microsns.repository.CommentRepository;
import com.example.microsns.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jdbc")
@RequiredArgsConstructor
public class JdbcCommentRepository implements CommentRepository {

    private final DataSource dataSource;

    @Override
    public List<Comment> findByBoardId(Long boardId) {
        String sql = "SELECT * FROM comment WHERE board_id = ? ORDER BY created_at";
        List<Comment> result = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setLong(1, boardId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
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
                result.add(comment);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        String sql = "SELECT * FROM comment WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getLong("id"));
                c.setBoardId(rs.getLong("board_id"));
                c.setWriter(rs.getString("writer"));
                c.setContent(rs.getString("content"));
                c.setPassword(rs.getString("password"));
                c.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                Timestamp modified = rs.getTimestamp("modified_at");
                if (modified != null) {
                    c.setModifiedAt(modified.toLocalDateTime());
                }

                return Optional.of(c);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Comment comment, Long boardId) {
        if (comment.getWriter() == null) {
            throw new IllegalArgumentException("작성자는 빈 값일 수 없습니다.");
        }
        String sql = "INSERT INTO comment (board_id, writer, content, password, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setLong(1, boardId);
            pstmt.setString(2, comment.getWriter());
            pstmt.setString(3, comment.getContent());
            pstmt.setString(4, comment.getPassword());
            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            int affected = pstmt.executeUpdate();

            if (affected == 1) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        long generatedId = rs.getLong(1);
                        System.out.println("generatedId = " + generatedId);
                        comment.setId(generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Long id, String password, String newContent) {
        String sql = "UPDATE comment SET content = ?, modified_at = ? WHERE id = ? AND password = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newContent);
            pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setLong(3, id);
            pstmt.setString(4, password);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id, String password) {
        String sql = "DELETE FROM comment WHERE id = ? AND password = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.setString(2, password);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
