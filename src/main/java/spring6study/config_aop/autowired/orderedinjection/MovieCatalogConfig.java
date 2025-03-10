package spring6study.config_aop.autowired.orderedinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class MovieCatalogConfig {

    @Bean
    @Order(1)
    public MovieCatalog firstMovieCatalog() {
        return new FirstMovieCatalog();
    }

    @Bean
    @Order(2)
    public MovieCatalog secondMovieCatalog() {
        return new SecondMovieCatalog();
    }
}