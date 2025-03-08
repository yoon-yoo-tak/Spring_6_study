package spring6study.config_aop.service;

import org.springframework.stereotype.Service;

@Service // 자동으로 빈 등록됨
public class UserService {
    public void printUser() {
        System.out.println("UserService: 사용자 정보를 조회합니다.");
    }
}