package spring6study.config_aop.interfaceConfig;

import org.springframework.context.annotation.Configuration;
import spring6study.config_aop.beanDependency.AccountRepository;
import spring6study.config_aop.beanDependency.JdbcAccountRepository;

@Configuration
public class DefaultRepositoryConfig implements RepositoryConfig {

    @Override
    public AccountRepository accountRepository() {
        return null;
    }
}
