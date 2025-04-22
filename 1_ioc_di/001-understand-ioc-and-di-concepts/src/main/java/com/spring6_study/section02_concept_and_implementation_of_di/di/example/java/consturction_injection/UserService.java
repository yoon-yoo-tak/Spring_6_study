package com.spring6_study.section02_concept_and_implementation_of_di.di.example.java.consturction_injection;

public class UserService {
    private final UserRepository userRepository;
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
