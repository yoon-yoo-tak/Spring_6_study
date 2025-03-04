package spring6study.config_aop.beanDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public TransferService transferService(AccountRepository accountRepository) {
        return new TransferServiceImpl(accountRepository);
    }

//    클래스간 의존성 주입
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Bean
//    public TransferService transferService() {
//        return new TransferServiceImpl(accountRepository);
//    }

//    설정 클래스간 탐색
//    @Autowired
//    private RepositoryConfig repositoryConfig;
//
//    @Bean
//    public TransferService transferService() {
//        return new TransferServiceImpl(repositoryConfig.accountRepository());
//    }
}