package spring6study.config_aop.autowired.orderedinjection;

import jakarta.annotation.Priority;
import org.springframework.stereotype.Component;

@Component
@Priority(1) // 가장 높은 우선순위
public class PriorityMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Priority Movie Catalog";
    }
}