package spring6study.config_aop.autowired.methodinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring6study.config_aop.autowired.methodinjection.CustomerPreferenceDao;

@Component
public class MovieRecommender {

    private MovieCatalog movieCatalog;
    private CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public void prepare(MovieCatalog movieCatalog, CustomerPreferenceDao customerPreferenceDao) {
        this.movieCatalog = movieCatalog;
        this.customerPreferenceDao = customerPreferenceDao;
    }

    public void recommend() {
        System.out.println(movieCatalog.getCatalog() + " based on " + customerPreferenceDao.getPreferences());
    }
}