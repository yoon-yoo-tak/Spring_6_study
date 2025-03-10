package spring6study.config_aop.basicAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring6study.config_aop.basicAnnotation.config.AppConfig;
import spring6study.config_aop.basicAnnotation.controller.UserController;

public class Main{
    public static void main(String[] args) {
        // ApplicationContext 초기화
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 빈 가져오기
        UserController userController = context.getBean(UserController.class);

        // 메서드 실행
        userController.showUserData();
    }
}
