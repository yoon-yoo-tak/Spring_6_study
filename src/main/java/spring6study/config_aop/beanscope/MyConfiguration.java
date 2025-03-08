package spring6study.config_aop.beanscope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
class MyConfiguration {
    @Bean
    @Scope("prototype")
    public Encryptor encryptor() {
        return new Encryptor();
    }
}