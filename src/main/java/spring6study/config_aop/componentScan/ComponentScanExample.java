package spring6study.config_aop.componentScan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring6study.config_aop.service.MyService;

public class ComponentScanExample {
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("spring6study.config_aop");
        ctx.refresh();
        System.out.println("check bean definition"); // BP

        MyService service = ctx.getBean(MyService.class);
        service.doSomething();

    }
}
