package spring6study.config_aop.autowired.collectioninjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MovieRecommender {

    @Autowired
    private MovieCatalog[] movieCatalogs; // 같은 타입의 모든 빈이 배열로 주입됨

    public void printCatalogs() {
        System.out.println("Available Movie Catalogs:");
        for (MovieCatalog catalog : movieCatalogs) {
            System.out.println("- " + catalog.getCatalogName());
        }
    }
}