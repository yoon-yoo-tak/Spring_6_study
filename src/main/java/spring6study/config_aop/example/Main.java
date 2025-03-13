package spring6study.config_aop.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        MyService myService = ctx.getBean(MyService.class);
        myService.doSomething();
        System.out.println();

        String data = myService.getData();
        System.out.println("data = " + data);
        System.out.println();

        try{
            myService.throwException();
        }catch (Exception e){}

    }
}
