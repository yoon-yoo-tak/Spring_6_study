package spring6study.config_aop.interfaceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring6study.config_aop.beanDependency.ServiceConfig;

import javax.sql.DataSource;

@Configuration
@Import({ServiceConfig.class, DefaultRepositoryConfig.class})
public class SystemConfig {
    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
