package spring6study.config_aop.qualifierWithCollectionAndOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // 특정 Qualifier("action")을 가진 빈들 출력
        MovieRecommender movieRecommender = context.getBean(MovieRecommender.class);
        movieRecommender.printCatalogs();
    }
}
