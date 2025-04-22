package com.spring6_study.__spring_bean_life_cycle.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PostConstructPreDestroyExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                PostConstructPreDestroyExample.class);
        DatabaseConnectionManager connectionManager = context.getBean(DatabaseConnectionManager.class);
        System.out.println("connectionManager.getConnection() = " + connectionManager.getConnection());
        context.close();
    }
}
