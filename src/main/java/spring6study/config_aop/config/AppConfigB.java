package spring6study.config_aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfigA.class)
public class AppConfigB {
    @Bean
    public B b(){
        return new B();
    }
}

class B{}
