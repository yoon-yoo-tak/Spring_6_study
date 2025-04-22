package com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.infra;

import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.annotation.MyPostConstruct;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.annotation.MyPreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionManager {
    private Connection connection;

    @MyPostConstruct
    public void connect() {
        try {
            System.out.println("데이터베이스 연결 설정 중...");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/testdb", "sa", "");
            System.out.println("데이터베이스 연결 성공");
        } catch (SQLException e) {
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }

    @MyPreDestroy
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
