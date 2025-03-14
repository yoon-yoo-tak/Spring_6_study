package spring6study.config_aop.autowired.customAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring6study.config_aop.autowired.customAnnotation")
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        System.out.println();
        MyService myService = ctx.getBean(MyService.class);
        myService.execute();
    }
}
