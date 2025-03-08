package spring6study.config_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring6study.config_aop.config.AppConfig;
import spring6study.config_aop.repository.UserRepository;
import spring6study.config_aop.service.UserService;

public class ConfigAopApplication {
    public static void main(String[] args) {
        // ApplicationContext 초기화
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 빈 가져오기
        UserService userService = context.getBean(UserService.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        // 메서드 실행
        userService.printUser();
        userRepository.getUserData();

    }
}



