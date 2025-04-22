package com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.service;

import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.domain.User;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.annotation.MyAutowired;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.annotation.MyComponent;
import com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.infra.UserRepository;

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

    public User registerUser(String name) {
        return userRepository.save(name);
    }
}
