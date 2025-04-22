package study.spring6jdbcweek3.post;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class PostRepository {

    public void save(Post post) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/spring6", "sa", "1234");
            pstmt = con.prepareStatement("insert into post(post_id, title, content, likes) values(?, ?, ?, ?)");
            pstmt.setLong(1, post.getPostId());
            pstmt.setString(2, post.getTitle());
            pstmt.setString(3, post.getContent());
            pstmt.setInt(4, post.getLikes());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    log.error("prepareStatement close error", e);
                    throw e;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    log.error("connection close error", e);
                    throw e;
                }
            }
        }
    }

    public Post findById(Long id) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/spring6", "sa", "1234");
            pstmt = con.prepareStatement("select * from post where post_id = ?");
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            return Post.of(rs.getLong("post_id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getInt("likes"));
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.error("resultSet close error", e);
                    throw e;
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    log.error("prepareStatement close error", e);
                    throw e;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    log.error("connection close error", e);
                    throw e;
                }
            }
        }
    }

    public void deleteAll() {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/spring6", "sa", "1234");
            pstmt = con.prepareStatement("delete from post");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    log.error("prepareStatement close error", e);
                    throw new RuntimeException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    log.error("connection close error", e);
                    throw new RuntimeException(e);
                }
            }
        }
    }
}