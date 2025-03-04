package spring6study.config_aop.lazyAndDependsOn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class DependsOnMain {
    public static void main(String[] args) {
        System.out.println("=== 컨텍스트 초기화 시작 ===");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DependsOnMain.class);
        System.out.println("=== 컨텍스트 초기화 완료 ===");

        // 빈 사용
        System.out.println("=== UserService 사용 ===");
        UserService userService = ctx.getBean(UserService.class);
    }
}
