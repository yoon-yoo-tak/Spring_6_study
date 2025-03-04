package spring6study.config_aop.lazyAndDependsOn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyMain {
    public static void main(String[] args) {
        System.out.println("=== 컨텍스트 초기화 시작 ===");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LazyAppConfig.class);
        System.out.println("=== 컨텍스트 초기화 완료 ===");

        System.out.println("=== ExpensiveService 사용 ==="); // BP
        ExpensiveService service = ctx.getBean("lazyExpensiveService", ExpensiveService.class);

        service.performTask();
    }
}
