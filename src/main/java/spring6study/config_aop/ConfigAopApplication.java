package spring6study.config_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class ConfigAopApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(UserService.class);

        System.out.println("Check ApplicationContext");

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

@Component
class MemberService{
    public String getMember(){
        return "member";
    }
}


