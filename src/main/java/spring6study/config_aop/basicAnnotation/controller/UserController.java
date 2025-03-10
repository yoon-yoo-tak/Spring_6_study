package spring6study.config_aop.basicAnnotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring6study.config_aop.basicAnnotation.service.UserService;

@Controller // 자동으로 빈 등록됨
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void showUserData() {
        System.out.println(userService.processUser());
    }
}