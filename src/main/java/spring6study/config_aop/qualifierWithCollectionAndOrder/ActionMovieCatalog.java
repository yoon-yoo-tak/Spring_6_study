package spring6study.config_aop.qualifierWithCollectionAndOrder;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("action")
@Order(1) // 첫 번째로 주입될 빈
public class ActionMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Action Movie Catalog";
    }
}
