package com.spring6_study.__comparing_as_is_ans_to_be_codes.java;

public class HumanResourceApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User registerdUser = userService.registerUser(1L, "홍길동");
        System.out.println("registeredUser = " + registerdUser);
        User foundUser = userService.findUser(1L);
        System.out.println("foundUser = " + foundUser);
    }
}
