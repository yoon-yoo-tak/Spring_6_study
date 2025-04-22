package com.spring6_study.section02_concept_and_implementation_of_di.di.example.spring.consturction_injection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private final Map<Long, User> userMap = new HashMap<>();
    public Optional<User> findUserById(Long userId) {
        System.out.println("유저를 조회합니다.");
        return Optional.ofNullable(userMap.get(userId));
    }
    public User save(
            User newUser) {
        System.out.println("유저를 등록합니다.");
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }
}
