package spring6study.config_aop.qualifierBasic;

import org.springframework.stereotype.Component;

@Component("mainMovieCatalog")  // "main" 빈 이름 등록
public class MainMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Main Movie Catalog";
    }
}
