package spring6study.config_aop.externalProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:app-info.properties")
public class AppInfo {

    @Value("${app.name}")
    private String name;

    @Value("${app.description}")
    private String description;

    @Value("${app.url}")
    private String url;

    @Override
    public String toString() {
        return "AppInfo(name='" + name + "', description='" + description + "', url='" + url + "')";
    }

    public void printInfo() {
        System.out.println(this);
    }
}
