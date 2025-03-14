package spring6study.config_aop.autowired.orderedinjection;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // 가장 높은 우선순위
public class FirstMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "First Movie Catalog";
    }
}