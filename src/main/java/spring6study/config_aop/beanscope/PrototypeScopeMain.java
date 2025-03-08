package spring6study.config_aop.beanscope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeScopeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        System.out.println("첫 번째 Encryptor 빈 요청");
        Encryptor e1 = context.getBean(Encryptor.class);
        System.out.println("두 번째 Encryptor 빈 요청");
        Encryptor e2 = context.getBean(Encryptor.class);

        System.out.println("e1 == e2 ? " + (e1 == e2)); // false
        context.close();
    }
}