package spring6study.config_aop.lifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig3 {
    @Bean
    public BeanThree beanThree() {
        return new BeanThree();
    }
}