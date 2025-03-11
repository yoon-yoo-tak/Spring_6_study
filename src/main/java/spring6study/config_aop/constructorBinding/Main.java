package spring6study.config_aop.constructorBinding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(AppInfo.class)  // ✅ AppInfo를 빈으로 등록
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        AppInfo appInfo = ctx.getBean(AppInfo.class);
        System.out.println(appInfo);
    }
}
