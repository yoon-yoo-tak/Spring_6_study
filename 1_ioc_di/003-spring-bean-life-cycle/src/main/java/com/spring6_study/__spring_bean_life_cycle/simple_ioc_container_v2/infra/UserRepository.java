package com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.infra;

import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.annotation.MyAutowired;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.annotation.MyComponent;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.infra.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.domain.User;

@MyComponent
public class UserRepository {

    private final DatabaseConnectionManager connectionManager;

    @MyAutowired
    public UserRepository(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Optional<User> findUserById(Long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getLong("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public User save(String name) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        Connection connection = connectionManager.getConnection();
        System.out.println("connection = " + connection);
        try (PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long generatedKeysLong = generatedKeys.getLong(1);
                    System.out.println("사용자 추가 완료 (ID: " + generatedKeysLong + ", Name: " + name + ")");
                    return new User(generatedKeysLong, name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
