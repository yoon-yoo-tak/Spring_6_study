package spring6study.config_aop.interfaceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring6study.config_aop.beanDependency.AccountRepository;

@Configuration
public interface RepositoryConfig {
    @Bean
    AccountRepository accountRepository();
}
