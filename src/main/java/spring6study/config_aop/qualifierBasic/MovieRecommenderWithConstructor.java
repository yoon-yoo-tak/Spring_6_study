package spring6study.config_aop.qualifierBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommenderWithConstructor {

    private final MovieCatalog movieCatalog;

    @Autowired
    public MovieRecommenderWithConstructor(@Qualifier("backup") MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public void printCatalog() {
        System.out.println("Selected Movie Catalog (Constructor Injection): " + movieCatalog.getCatalogName());
    }
}
