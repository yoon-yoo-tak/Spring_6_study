package spring6study.config_aop.lifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
class AppConfig4 {
    @Bean(destroyMethod = "")
    public DataSource dataSource() {
        System.out.println("DataSource 빈 생성!");
        return new DriverManagerDataSource();
    }
}