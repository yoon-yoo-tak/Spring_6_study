package spring6study.config_aop.basicAnnotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring6study.config_aop.basicAnnotation.repository.UserRepository;

@Service // 자동으로 빈 등록됨
public class UserService {
    private final UserRepository userRepository;

    @Autowired // 의존성 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String processUser() {
        return "서비스 처리: " + userRepository.getUserData();
    }
}