package spring6study.config_aop.autowired.orderedinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieRecommender {

    private final List<MovieCatalog> movieCatalogs;

    @Autowired
    public MovieRecommender(List<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    public void printCatalogs() {
        System.out.println("🎥 Available Movie Catalogs (Ordered List):");
        for (MovieCatalog catalog : movieCatalogs) {
            System.out.println("- " + catalog.getCatalogName());
        }
    }
}