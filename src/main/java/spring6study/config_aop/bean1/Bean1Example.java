package spring6study.config_aop.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bean1Example {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("check bean definition"); // BP

        BeanOne beanOne = (BeanOne) ctx.getBean("beanOne");
        beanOne.execute();

    }
}
