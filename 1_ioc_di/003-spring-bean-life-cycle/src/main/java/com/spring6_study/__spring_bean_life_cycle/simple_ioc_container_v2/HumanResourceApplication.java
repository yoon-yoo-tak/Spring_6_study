package com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2;


import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.domain.User;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.infra.DatabaseConnectionManager;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.ioc_container.MyApplicationContext;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.infra.UserRepository;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HumanResourceApplication {
    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext(UserRepository.class, UserService.class,
                DatabaseConnectionManager.class);
        DatabaseConnectionManager contextBean = context.getBean(DatabaseConnectionManager.class);
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "    id BIGINT AUTO_INCREMENT PRIMARY KEY,\n"
                + "    name VARCHAR(50) NOT NULL\n);";
        Connection connection = contextBean.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("users 테이블이 생성되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserService userService = context.getBean(UserService.class);
        User registeredUser = userService.registerUser("홍길동");
        System.out.println("registeredUser = " + registeredUser);
        User foundUser = userService.findUser(registeredUser.getId());
        System.out.println("foundUser = " + foundUser);
        context.close();
    }
}
