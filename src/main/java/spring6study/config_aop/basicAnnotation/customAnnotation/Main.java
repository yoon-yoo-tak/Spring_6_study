package spring6study.config_aop.basicAnnotation.customAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring6study.config_aop.basicAnnotation.customAnnotation")
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        MyService myService = ctx.getBean(MyService.class);
        myService.execute();
    }
}
