package spring6study.config_aop.lazyAndDependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LazyAppConfig {

    // Context 시작 시 즉시 생성
    @Bean
    public ExpensiveService eagerExpensiveService() {
        return new ExpensiveService();
    }

    // 필요할 때 생성
    @Bean
    @Lazy
    public ExpensiveService lazyExpensiveService() {
        return new ExpensiveService();
    }
}
