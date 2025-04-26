package com.example.microsns;

import com.example.microsns.domain.Board;
import com.example.microsns.domain.Comment;
import com.example.microsns.repository.ConnectionHolder;
import com.example.microsns.repository.jdbc.JdbcBoardRepository;
import com.example.microsns.repository.jdbc.JdbcCommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("jdbc")
public class BoardEntityServiceJdbcTxTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcBoardRepository boardRepository;

    @Test
    void 게시글_등록_예외_발생시_롤백() throws SQLException {
        Connection conn = dataSource.getConnection();
        ConnectionHolder.set(conn);
        conn.setAutoCommit(false);

        try {
            Board board = new Board();
            board.setTitle(null);
            board.setContent("내용");
            board.setWriter("작성자");
            board.setPassword("1234");
            board.setCreatedAt(LocalDateTime.now());

            boardRepository.save(board);

            conn.commit();
        } catch (Exception e) {
            System.out.println("롤백" + e.getMessage());
            conn.rollback();
        } finally {
            conn.close();
            ConnectionHolder.clear();
        }
        List<Board> all = boardRepository.findAll();
        assertThat(all).isEmpty();
    }
}
