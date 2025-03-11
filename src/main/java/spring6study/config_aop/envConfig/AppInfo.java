package spring6study.config_aop.envConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class AppInfo {

    private final Environment environment;

    private String name;
    private String description;
    private String url;
    private int version;

    public AppInfo(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void init() {
        name = environment.getProperty("myapp.name");
        description = environment.getProperty("myapp.description");
        url = environment.getProperty("myapp.url");
        version = environment.getProperty("myapp.version", Integer.class, 10);
    }

    @Override
    public String toString() {
        return "AppInfo(name='" + name + "', description='" + description + "', url='" + url + "', version=" + version + ")";
    }
}
