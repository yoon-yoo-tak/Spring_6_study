package spring6study.config_aop.autowired.setterinjection;

import org.springframework.stereotype.Component;

@Component
public class MovieFinder {

    public String findMovies() {
        return "List of movies";
    }
}