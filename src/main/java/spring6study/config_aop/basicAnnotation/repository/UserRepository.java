package spring6study.config_aop.basicAnnotation.repository;

import org.springframework.stereotype.Repository;

@Repository // 자동으로 빈 등록됨
public class UserRepository {
    public String getUserData() {
        return "사용자 데이터베이스 정보";
    }
}