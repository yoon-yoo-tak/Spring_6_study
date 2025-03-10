package spring6study.config_aop.qualifierBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommenderWithSetter {

    private MovieCatalog movieCatalog;

    @Autowired
    public void setMovieCatalog(@Qualifier("mainMovieCatalog") MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public void printCatalog() {
        System.out.println("Selected Movie Catalog (Setter Injection): " + movieCatalog.getCatalogName());
    }
}
