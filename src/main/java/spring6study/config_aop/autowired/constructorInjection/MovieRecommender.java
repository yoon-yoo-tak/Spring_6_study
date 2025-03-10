package spring6study.config_aop.autowired.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MovieRecommender {

    private final CustomerPreferenceDao customerPreferenceDao;

    @Autowired // 생략 가능
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }

    public void recommend() {
        System.out.println("Recommendation based on " + customerPreferenceDao.getPreferences());
    }
}
