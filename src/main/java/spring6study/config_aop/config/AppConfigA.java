package spring6study.config_aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigA {
    @Bean
    public A a(){
        return new A();
    }
}

class A{

}