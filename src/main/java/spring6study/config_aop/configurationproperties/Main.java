package spring6study.config_aop.configurationproperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@EnableConfigurationProperties(AppInfo.class)
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        System.out.println();
        AppInfo app = ctx.getBean(AppInfo.class);
        System.out.println(app);
    }
}



//@SpringBootApplication
//public class Main {
//    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(Main.class, args);
//        AppInfo appInfo = ctx.getBean(AppInfo.class);
//        System.out.println(appInfo);
//    }
//}