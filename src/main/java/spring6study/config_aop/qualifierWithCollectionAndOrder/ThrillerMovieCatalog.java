package spring6study.config_aop.qualifierWithCollectionAndOrder;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("thriller")
@Order(2) // 두 번째로 주입될 빈
public class ThrillerMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Thriller Movie Catalog";
    }
}
