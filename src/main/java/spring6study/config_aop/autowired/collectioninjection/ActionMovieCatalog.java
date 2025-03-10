package spring6study.config_aop.autowired.collectioninjection;

import org.springframework.stereotype.Component;

@Component
public class ActionMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Action Movies";
    }
}
