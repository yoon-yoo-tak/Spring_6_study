package com.spring6_study.__spring_bean_life_cycle.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionManager {
    private Connection connection;

    @PostConstruct
    public void connect() {
        try {
            System.out.println("데이터베이스 연결 설정 중...");
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            System.out.println("데이터베이스 연결 성공");
        } catch (SQLException e) {
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }

    @PreDestroy
    public void disconnect() {
        try {
            System.out.println("데이터베이스 연결 해제 중...");
            connection.close();
            System.out.println("데이터베이스 연결 해제 성공");
        } catch (SQLException e) {
            throw new RuntimeException("데이터베이스 연결 해제 실패");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
