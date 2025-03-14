package spring6study.config_aop.pointcutExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring6study.config_aop.pointcutExample.service.AccountService;
import spring6study.config_aop.pointcutExample.service.PaymentService;

@Configuration
@ComponentScan("spring6study.config_aop.pointcutExample")
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        PaymentService paymentService = ctx.getBean(PaymentService.class);

        System.out.println("=== PointCut 예제 ===");
        accountService.createAccount();
        accountService.loggableMethod();
        accountService.secureTransaction("TXN123");
        paymentService.processPayment("2147483647");
    }
}
