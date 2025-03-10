package spring6study.config_aop.autowired.methodinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring6study.config_aop.autowired.methodinjection.MovieRecommender;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        MovieRecommender recommender= ctx.getBean(MovieRecommender.class);
        recommender.recommend();

    }
}
