package spring6study.config_aop.autowired.orderedinjection;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(2) // 두 번째 우선순위
public class SecondMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Second Movie Catalog";
    }
}