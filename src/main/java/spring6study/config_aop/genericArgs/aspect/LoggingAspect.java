package spring6study.config_aop.genericArgs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;

@Aspect
@Component
public class LoggingAspect {

    // 특정 제네릭 타입을 매칭 (String)
    @Before("execution (* spring6study.config_aop.genericArgs.service.GenericService+.genericMethod(*)) &&" +
            "args(param)")
    public void beforeGenericMethod(String param){
        System.out.println("[LOG] String 타입의 매개변수 : " + param);
    }

    // 모든 제네릭 타입을 매칭(Object)
    @Before("execution(* spring6study.config_aop.genericArgs.service.GenericService+.genericMethod(*)) &&" +
            "args(param)")
    public void beforeGenericAnyTypeMethod(Object param){
        System.out.println("[LOG] 모든 타입의 매개변수 : " + param);
    }

    @Before("execution(* spring6study.config_aop.genericArgs.service.GenericService+.genericCollectionMethod(*)) &&" +
            " args(param)")
    public void beforeGenericCollectionMethod(Collection<?> param) {
        System.out.println("[AOP] Collection 매개변수 (원소 개수: " + param.size() + ")");

        for (Object obj : param) {
            if (obj instanceof String) {
                System.out.println("  - (String) 요소: " + obj);
            }
        }
    }

//    @Around("execution (* spring6study.config_aop.genericArgs.service.GenericService+.genericMethod(*)) &&" +
//            "args(param)")
//    public Object changeArgument(ProceedingJoinPoint joinPoint, String param) throws Throwable {
//        String newPattern = param.repeat(3);
//        return joinPoint.proceed(new Object[]{newPattern});
//    }
}
