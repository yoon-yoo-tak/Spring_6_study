package spring6study.config_aop.lifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig2 {
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }
}