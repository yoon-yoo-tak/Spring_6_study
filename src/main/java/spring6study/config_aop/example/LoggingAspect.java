package spring6study.config_aop.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* spring6study.config_aop.example.MyService.*(..))")
    public void logBefore(){
        System.out.println("[Before] 메서드 실행 전에 로그 출력");
    }

    @AfterReturning(value = "execution(* spring6study.config_aop.example.MyService.*(..))", returning = "result")
    public void logAfterReturning(Object result){
        System.out.println("[AfterReturning] 정상 실행 후 반환값 : " + result);
    }

    @AfterThrowing(value = "execution(* spring6study.config_aop.example.MyService.*(..))", throwing = "ex")
    public void logAfterThrowing(Exception ex) {
        System.out.println("[AfterThrowing] 예외 발생: " + ex.getMessage());
    }

    @After("execution(* spring6study.config_aop.example.MyService.*(..))")
    public void logAfter() {
        System.out.println("[After] 메서드 실행 완료 (정상/예외 무관)");
    }

    @Around("execution(* spring6study.config_aop.example.MyService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around] 실행 전: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // 실제 메서드 실행
        System.out.println("[Around] 실행 후: " + joinPoint.getSignature().getName());
        return result;
    }
}
