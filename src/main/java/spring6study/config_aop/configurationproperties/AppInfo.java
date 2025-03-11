package spring6study.config_aop.configurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Setter
@ConfigurationProperties(prefix = "myapp")
public class AppInfo {
    private String name;
    private String description;
    private String url;
    private UserInfo user = new UserInfo();

    @Getter
    @Setter
    public static class UserInfo {
        private String username;
        private String password;
        private Set<String> roles;

        @Override
        public String toString() {
            return "UserInfo(username='" + username + "', password='" + password + "', roles=" + roles + ")";
        }
    }

    @Override
    public String toString() {
        return "AppInfo(name='" + name + "', description='" + description + "', url='" + url + "', user=" + user + ")";
    }
}
