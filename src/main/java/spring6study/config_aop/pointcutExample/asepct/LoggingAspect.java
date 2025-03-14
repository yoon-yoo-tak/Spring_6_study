package spring6study.config_aop.pointcutExample.asepct;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // 1. execution - 특정 메서드 실행시
    @Before("execution(* spring6study.config_aop.pointcutExample.service.AccountService.*(..))")
    public void logExecution(){
        System.out.println("[execution] AccountService 의 메서드 실행");
    }

    // 2. within - 특정 패키지 내부의 모든 메서드 실행시
    @Before("within(spring6study.config_aop.pointcutExample.service..*)")
    public void logWithin(){
        System.out.println("[within] com.example.service 패키지 내부 메서드 실행");
    }

    // 3. this - 프록시 객체가 특정 타입일때
    @Before("this(spring6study.config_aop.pointcutExample.service.AccountService)")
    public void logThis(){
        System.out.println("[this] 프록시가 AccountService 타입일 때 실행");
    }

    // 4. target - 실제 객체가 특정 타입일때
    @Before("target(spring6study.config_aop.pointcutExample.service.AccountService)")
    public void logTarget(){
        System.out.println("[target] 실제 객체가 AccountService 일 때 실행");
    }

    // 5. args - 특정 타입의 매개변수를 받는 메서드 실행시
    @Before("args(String)")
    public void logArgs(){
        System.out.println("[args] String 타입의 매개변수를 받는 메서드 실행");
    }

    // 6. @target - 특정 어노테이션이 붙은 클래스의 메서드 실행시
    @Before("@target(org.springframework.stereotype.Service)")
    public void logAtTarget(){
        System.out.println("[@target] @Service 어노테이션이 붙은 클래스의 메서드 실행");
    }

    // 7. @annotation - 특정 어노테이션이 붙은 메서드 실행시
    @Before("@annotation(spring6study.config_aop.pointcutExample.Loggable)")
    public void logAtAnnotation(){
        System.out.println("[@annotation] @Loggable 어노테이션이 붙은 메서드 실행");
    }

    // 8. @args - 특정 어노테이션이 붙은 매개변수를 받는 메서드 실행시
    @Before("@args(spring6study.config_aop.pointcutExample.Secure)")
    public void logAtArgs(){
        System.out.println("[@args] @Secure 어노테이션이 붙은 매개변수를 받는 메서드 실행");
    }

    // 9. bean - 특정 이름의 bean 에서 실행될 때
    @Before("bean(accountService)")
    public void logBean(){
        System.out.println("[bean] accountService 빈에서 실행됨");
    }
}
