package spring6study.config_aop.autowired.collectioninjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MovieRecommenderWithCollection {

    private Set<MovieCatalog> movieCatalogs;

    @Autowired
    public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    public void printCatalogs() {
        System.out.println("Available Movie Catalogs (using Collection):");
        for (MovieCatalog catalog : movieCatalogs) {
            System.out.println("- " + catalog.getCatalogName());
        }
    }
}
