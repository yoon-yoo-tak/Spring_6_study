package spring6study.config_aop.beanDependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {
    
    // AccountRepository 빈 등록
    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository();
    }

    // TransferService 빈 등록 (의존성: AccountRepository)
    @Bean
    public TransferService transferService(AccountRepository accountRepository) {
        return new TransferServiceImpl(accountRepository);  // 생성자로 주입
    }
}