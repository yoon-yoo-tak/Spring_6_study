package spring6study.config_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring6study.config_aop.service.Dependency1;
import spring6study.config_aop.service.Dependency2;
import spring6study.config_aop.service.MyService;
import spring6study.config_aop.service.MyServiceImpl;

public class ConfigAopApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyServiceImpl.class, Dependency1.class, Dependency2.class);

        System.out.println("check bean");

        MyService myService = ctx.getBean(MyService.class);
        myService.doSomething();

    }
}



