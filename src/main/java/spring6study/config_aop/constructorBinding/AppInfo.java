package spring6study.config_aop.constructorBinding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;

@ConfigurationProperties(prefix = "newapp")
public class AppInfo {

    private final String name;
    private final String description;
    private final String url;
    private final String emptyValue;
    private final UserInfo user;

    @ConstructorBinding
    public AppInfo(String name, String description, String url,
                   @DefaultValue("default value") String emptyValue,
                   @DefaultValue UserInfo user) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.emptyValue = emptyValue;
        this.user = user;
    }

    public static class UserInfo {
        private final String username;
        private final String password;
        private final Set<String> roles;

        @ConstructorBinding
        public UserInfo(String username, String password, Set<String> roles) {
            this.username = username;
            this.password = password;
            this.roles = roles;
        }

        @Override
        public String toString() {
            return "UserInfo(username='" + username + "', password='" + password + "', roles=" + roles + ")";
        }
    }

    @Override
    public String toString() {
        return "AppInfo(name='" + name + "', description='" + description + "', url='" + url + "', emptyValue='" + emptyValue + "', user=" + user + ")";
    }
}
