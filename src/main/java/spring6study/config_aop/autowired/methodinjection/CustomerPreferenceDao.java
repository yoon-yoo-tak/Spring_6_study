package spring6study.config_aop.autowired.methodinjection;

import org.springframework.stereotype.Component;

@Component
public class CustomerPreferenceDao {

    public String getPreferences() {
        return "User preferences";
    }
}