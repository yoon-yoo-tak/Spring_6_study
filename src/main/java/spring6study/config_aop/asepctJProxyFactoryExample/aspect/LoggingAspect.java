package spring6study.config_aop.asepctJProxyFactoryExample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* spring6study.config_aop.asepctJProxyFactoryExample.service.OrderService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] 메서드 실행 전: " + joinPoint.getSignature().getName());
    }
}