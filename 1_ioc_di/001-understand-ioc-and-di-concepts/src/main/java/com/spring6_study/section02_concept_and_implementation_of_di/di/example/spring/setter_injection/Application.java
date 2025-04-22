package com.spring6_study.section02_concept_and_implementation_of_di.di.example.spring.setter_injection;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(
                UserService.class);
        User user1 = userService.registerUser(1L, "김철수");
        System.out.println("user1 = " + user1);
        User findUser = userService.findUser(1L);
        System.out.println("findUser = " + findUser);
    }
}
