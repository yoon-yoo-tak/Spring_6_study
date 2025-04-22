package com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.service;

import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.annotation.MyComponent;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@MyComponent
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
