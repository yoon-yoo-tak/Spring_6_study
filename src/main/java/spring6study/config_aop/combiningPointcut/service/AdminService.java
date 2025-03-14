package spring6study.config_aop.combiningPointcut.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public void manageUsers() {
        System.out.println("AdminService: 사용자 관리\n");
    }
}