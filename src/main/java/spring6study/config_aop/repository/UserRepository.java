package spring6study.config_aop.repository;

import org.springframework.stereotype.Repository;

@Repository // 자동으로 빈 등록됨
public class UserRepository {
    public void getUserData() {
        System.out.println("UserRepository: 데이터베이스에서 사용자 데이터를 가져옵니다.");
    }
}