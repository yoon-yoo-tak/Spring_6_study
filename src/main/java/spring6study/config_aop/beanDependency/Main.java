package spring6study.config_aop.beanDependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
        
        // 빈 가져오기
        TransferService transferService = ctx.getBean(TransferService.class);
        
        // 계좌 이체 실행
        transferService.transfer(100.00, "A123", "C456");
    }
}