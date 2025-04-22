package com.spring6_study.__comparing_as_is_ans_to_be_codes.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HumanResourceApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                HumanResourceApplication.class);
        UserService userService = context.getBean(UserService.class);
        User registerdUser = userService.registerUser(1L, "홍길동");
        System.out.println("registeredUser = " + registerdUser);
        User foundUser = userService.findUser(1L);
        System.out.println("foundUser = " + foundUser);
    }
}
