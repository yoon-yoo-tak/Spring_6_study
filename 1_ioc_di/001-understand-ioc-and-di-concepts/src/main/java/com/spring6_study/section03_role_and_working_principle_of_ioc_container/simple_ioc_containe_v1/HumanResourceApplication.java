package com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1;

import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.domain.User;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.ioc_container.MyApplicationContext;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.service.UserRepository;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.service.UserService;

public class HumanResourceApplication {
    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext(UserRepository.class, UserService.class);
        UserService userService = context.getBean(UserService.class);
        User registeredUser = userService.registerUser(1L, "홍길동");
        System.out.println("registeredUser = " + registeredUser);
        User foundUser = userService.findUser(1L);
        System.out.println("foundUser = " + foundUser);
    }
}
