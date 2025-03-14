package spring6study.config_aop.introductions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring6study.config_aop.introductions.aop.UsageTracked;
import spring6study.config_aop.introductions.service.MyService;

@Configuration
@ComponentScan("spring6study.config_aop.introductions")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        UsageTracked myService = ctx.getBean("myService", UsageTracked.class);
        System.out.println(myService.getUseCount());


//         UsageTracked usageTracked2 = ctx.getBean("myService", UsageTracked.class);
//         System.out.println("최종 사용 횟수: " + usageTracked2.getUseCount());
    }
}