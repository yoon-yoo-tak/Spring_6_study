package com.spring6_study.section02_concept_and_implementation_of_di.di.example.java.setter_injection;


public class Application {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        User user1 = userService.registerUser(1L, "김철수");
        System.out.println("user1 = " + user1);
        User findUser = userService.findUser(1L);
        System.out.println("findUser = " + findUser);
    }
}
