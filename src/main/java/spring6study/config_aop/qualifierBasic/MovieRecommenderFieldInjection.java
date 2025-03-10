package spring6study.config_aop.qualifierBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommenderFieldInjection {

    @Autowired
    @Qualifier("mainMovieCatalog")  // "main" 빈을 주입받음
    private MovieCatalog movieCatalog;

    public void printCatalog() {
        System.out.println("Selected Movie Catalog (Field Injection): " + movieCatalog.getCatalogName());
    }
}
