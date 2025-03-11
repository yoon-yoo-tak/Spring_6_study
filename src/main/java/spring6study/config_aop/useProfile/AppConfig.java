package spring6study.config_aop.useProfile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
//
//    @Bean("dataSource")
//    @Profile("dev")
//    public DataSource devDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:schema-dev.sql")
//                .addScript("classpath:dev-data.sql")
//                .build();
//    }
//
//    @Bean("dataSource")
//    @Profile("prod")
//    public DataSource prodDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:schema-prod.sql")
//                .addScript("classpath:prod-data.sql")
//                .build();
//    }
}
