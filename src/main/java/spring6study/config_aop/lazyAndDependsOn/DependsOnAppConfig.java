package spring6study.config_aop.lazyAndDependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependsOnAppConfig {

    @Bean
    public DatabaseInitializer databaseInitializer() {
        return new DatabaseInitializer();
    }

    @Bean
    @DependsOn("databaseInitializer")
    public UserService userService() {
        return new UserService();
    }

}
