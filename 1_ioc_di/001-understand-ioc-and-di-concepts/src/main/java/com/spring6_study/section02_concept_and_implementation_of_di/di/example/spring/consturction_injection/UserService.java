package com.spring6_study.section02_concept_and_implementation_of_di.di.example.spring.consturction_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserRepository userRepository;

    // 생성자로 주입 받아야할 객체가 하나라면 @Autowired를 생략할 수 있다.
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUser(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    public User registerUser(Long userId, String name) {
        return userRepository.save(new User(userId, name));
    }
}
