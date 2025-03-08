package spring6study.config_aop.parentBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("check");
        BankController controller = ctx.getBean(BankController.class);
        controller.processTransfer();
    }
}
