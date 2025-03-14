package spring6study.config_aop.genericArgs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring6study.config_aop.genericArgs.service.StringService;

import java.util.Arrays;

@Configuration
@ComponentScan("spring6study.config_aop.genericArgs")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        System.out.println();
        StringService stringService = ctx.getBean(StringService.class);
        stringService.genericMethod("Hello AOP ");
        stringService.genericCollectionMethod(Arrays.asList("Hello", "AOP", "Generic"));
    }
}
