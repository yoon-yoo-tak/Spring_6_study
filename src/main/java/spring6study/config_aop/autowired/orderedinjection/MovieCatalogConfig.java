package spring6study.config_aop.autowired.orderedinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class MovieCatalogConfig {

    @Bean
    public MovieCatalog firstMovieCatalog() {
        return new FirstMovieCatalog();
    }

    @Bean
    public MovieCatalog secondMovieCatalog() {
        return new SecondMovieCatalog();
    }
}