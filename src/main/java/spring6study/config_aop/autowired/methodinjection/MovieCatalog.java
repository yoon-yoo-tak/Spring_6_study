package spring6study.config_aop.autowired.methodinjection;

import org.springframework.stereotype.Component;

@Component
public class MovieCatalog {

    public String getCatalog() {
        return "Movie catalog";
    }
}