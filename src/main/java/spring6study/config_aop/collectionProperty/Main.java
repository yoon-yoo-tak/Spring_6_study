package spring6study.config_aop.collectionProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        ListProperty listProperty = ctx.getBean(ListProperty.class);
        System.out.println(listProperty.getColorlist());

        MapProperty mapProperty = ctx.getBean(MapProperty.class);
        System.out.println(mapProperty.getMap());
    }
}
