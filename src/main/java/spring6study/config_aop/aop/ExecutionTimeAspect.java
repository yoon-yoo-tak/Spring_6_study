package spring6study.config_aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class ExecutionTimeAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    // 서비스 계층의 모든 메서드에 적용
    @Around("execution(* spring6study.config_aop.service..*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        
        logger.info("Method {} executed in {} ms", joinPoint.getSignature(), (end - start));
        
        return result;
    }
}
