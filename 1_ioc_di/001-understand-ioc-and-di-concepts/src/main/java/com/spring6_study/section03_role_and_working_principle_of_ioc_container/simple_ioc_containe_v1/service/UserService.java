package com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.service;

import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.annotation.MyAutowired;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.domain.User;
import com.spring6_study.section03_role_and_working_principle_of_ioc_container.simple_ioc_containe_v1.annotation.MyComponent;

@MyComponent
public class UserService {
    private final UserRepository userRepository;

    @MyAutowired
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
