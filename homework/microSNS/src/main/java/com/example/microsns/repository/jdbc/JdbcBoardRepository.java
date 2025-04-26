package com.example.microsns.repository.jdbc;

import com.example.microsns.repository.BoardRepository;
import com.example.microsns.domain.Board;
import com.example.microsns.repository.ConnectionHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("jdbc")
public class JdbcBoardRepository implements BoardRepository {

    private final DataSource dataSource;

    @Override
    public void save(Board board) throws SQLException{
        String sql = "INSERT INTO board (title, content, writer, password)" +
                "values (?, ?, ?, ?)";
        Connection conn = ConnectionHolder.get();
        if (conn == null) {
            conn = dataSource.getConnection();
        }
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());
            pstmt.setString(4, board.getPassword());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Board findById(Long id) {
        String sql = "SELECT * FROM board WHERE id = ?";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1, id);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()){
                    return toBoard(rs);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("게시글 조회 실패", e);
        }
        return null;
    }

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM board order by id desc";
        List<Board> boardList = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql)) {
            while (rs.next()) {
                boardList.add(toBoard(rs));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return boardList;
    }

    @Override
    public void update(Board board) {
        String sql = "UPDATE board SET title=?, content=?, modified_at=NOW() WHERE id=? AND password=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setLong(3, board.getId());
            pstmt.setString(4, board.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("게시글 수정 실패", e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM board WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("게시글 삭제 실패", e);
        }
    }


    @Override
    public List<Board> findRecent(int limit) {
        String sql = "SELECT * FROM board ORDER BY id DESC LIMIT ?";
        List<Board> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, limit);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.add(toBoard(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Board> findOlderThan(Long lastId, int limit) {
        String sql = "SELECT * FROM board WHERE id < ? ORDER BY id DESC LIMIT ?";
        List<Board> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, lastId);
            pstmt.setInt(2, limit);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.add(toBoard(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Board toBoard(ResultSet rs) throws SQLException {
        Board board = new Board();
        board.setId(rs.getLong(1));
        board.setTitle(rs.getString(2));
        board.setContent(rs.getString(3));
        board.setWriter(rs.getString(4));
        board.setPassword(rs.getString(5));
        board.setCreatedAt(rs.getTimestamp(6).toLocalDateTime());
        board.setModifiedAt(rs.getTimestamp(7) != null ? rs.getTimestamp("modified_at").toLocalDateTime() : null);
        return board;
    }
}
