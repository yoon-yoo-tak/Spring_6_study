package spring6study.config_aop.qualifierBasic;

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

        // 필드 주입 예제 실행
        MovieRecommenderFieldInjection movieRecommender = context.getBean(MovieRecommenderFieldInjection.class);
        movieRecommender.printCatalog();

        // 생성자 주입 예제 실행
        MovieRecommenderWithConstructor constructorRecommender = context.getBean(MovieRecommenderWithConstructor.class);
        constructorRecommender.printCatalog();

        // Setter 주입 예제 실행
        MovieRecommenderWithSetter setterRecommender = context.getBean(MovieRecommenderWithSetter.class);
        setterRecommender.printCatalog();
    }
}
