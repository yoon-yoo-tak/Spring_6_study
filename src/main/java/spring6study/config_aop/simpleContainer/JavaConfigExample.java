package spring6study.config_aop.simpleContainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class JavaConfigExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(UserService.class);
        System.out.println("check bean definition");
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.getUser());
    }
}

@Configuration
class UserService{
    public String getUser(){
        return "user";
    }
}