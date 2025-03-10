package spring6study.config_aop.qualifierWithCollectionAndOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class MovieRecommender {

    private final Set<MovieCatalog> movieCatalogs;

    @Autowired
    public MovieRecommender(@Qualifier("action") Set<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    public void printCatalogs() {
        System.out.println("Movie Catalogs with @Qualifier(\"action\"):");
        for (MovieCatalog catalog : movieCatalogs) {
            System.out.println("- " + catalog.getCatalogName());
        }
    }
}
