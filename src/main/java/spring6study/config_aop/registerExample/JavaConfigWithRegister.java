package spring6study.config_aop.registerExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring6study.config_aop.service.Dependency1;
import spring6study.config_aop.service.Dependency2;
import spring6study.config_aop.service.MyService;
import spring6study.config_aop.service.MyServiceImpl;

public class JavaConfigWithRegister {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyServiceImpl.class, Dependency1.class);
        ctx.register(MyServiceImpl.class, Dependency1.class);
        ctx.register(Dependency2.class);
        ctx.refresh();

        System.out.println("check bean definition"); // BP

        MyService service = ctx.getBean(MyService.class);
        service.doSomething();
    }
}
