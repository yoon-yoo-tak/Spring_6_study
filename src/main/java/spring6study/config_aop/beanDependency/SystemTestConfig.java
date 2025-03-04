package spring6study.config_aop.beanDependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})  // 두 개의 설정 클래스를 한 번에 불러옴
public class SystemTestConfig {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}