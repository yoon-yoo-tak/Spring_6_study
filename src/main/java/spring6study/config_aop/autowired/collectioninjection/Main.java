package spring6study.config_aop.autowired.collectioninjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        MovieRecommender movieRecommender = ctx.getBean(MovieRecommender.class);
        movieRecommender.printCatalogs();

        MovieRecommenderWithCollection movieRecommenderWithCollection = ctx.getBean(MovieRecommenderWithCollection.class);
        movieRecommenderWithCollection.printCatalogs();


    }
}
