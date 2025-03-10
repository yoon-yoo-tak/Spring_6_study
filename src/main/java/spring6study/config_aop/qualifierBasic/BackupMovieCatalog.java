package spring6study.config_aop.qualifierBasic;

import org.springframework.stereotype.Component;

@Component("backup")  // "backup" 빈 이름 등록
public class BackupMovieCatalog implements MovieCatalog {
    @Override
    public String getCatalogName() {
        return "Backup Movie Catalog";
    }
}
