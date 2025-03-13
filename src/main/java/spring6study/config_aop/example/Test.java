package spring6study.config_aop.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        MyService1 myService1 = context.getBean(MyService1.class);
        myService1.methodA();
    }
}

@Aspect
class LoggingAspect1 {
    @Before("execution(* spring6study.config_aop.example.*.*(..))")
    public void beforeAdvice() {
        System.out.println("메서드 실행 전 로깅");
    }
}

@Service
class MyService1 {
    public void methodA() {
        System.out.println("methodA 실행");
        methodB(); // 내부 호출 (Self Invocation 문제 발생)
    }

    public void methodB() {
        System.out.println("methodB 실행");
    }
}
