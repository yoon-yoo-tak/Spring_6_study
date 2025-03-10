package spring6study.config_aop.autowired.collectioninjection;

import org.springframework.stereotype.Component;

@Component
public class ComedyMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Comedy Movies";
    }
}
