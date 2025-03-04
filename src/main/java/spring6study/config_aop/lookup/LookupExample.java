package spring6study.config_aop.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LookupExample {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 싱글톤 CommandManager 빈 가져오기
        CommandManager manager = context.getBean(CommandManager.class);

        // 여러 번 호출하여 각각 다른 AsyncCommand 객체가 생성되는지 확인
        Object result1 = manager.process("First Command");
        Object result2 = manager.process("Second Command");

        System.out.println(result1);
        System.out.println(result2);
    }
}
