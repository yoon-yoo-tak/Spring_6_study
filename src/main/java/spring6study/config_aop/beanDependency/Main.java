package spring6study.config_aop.beanDependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // TransferService 빈 가져오기
        TransferService service = context.getBean(TransferService.class);
        service.transfer();
    }
}