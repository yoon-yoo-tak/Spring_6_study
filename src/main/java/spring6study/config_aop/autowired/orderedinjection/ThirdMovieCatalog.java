package spring6study.config_aop.autowired.orderedinjection;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ThirdMovieCatalog implements MovieCatalog, Ordered {

    @Override
    public String getCatalogName() {
        return "Third Movie Catalog";
    }

    @Override
    public int getOrder() {
        return 3; // 낮을수록 높은 우선순위
    }
}