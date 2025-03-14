package spring6study.config_aop.combiningPointcut.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void getUserInfo() {
        System.out.println("UserService: 사용자 정보 조회\n");
    }
}