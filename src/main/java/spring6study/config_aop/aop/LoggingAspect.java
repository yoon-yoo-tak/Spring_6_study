package spring6study.config_aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Around("execution(* spring6study.config_aop.service..*(..))") // 서비스 계층의 모든 메서드에 적용
    public Object logExecutionDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        Map<String, Object> logData = new HashMap<>();
        logData.put("timestamp", LocalDateTime.now());
        logData.put("method", joinPoint.getSignature().toString());
        logData.put("executionTime", (end - start) + " ms");
        logData.put("arguments", joinPoint.getArgs());

        logger.info("Execution Log: {}", logData);

        return result;
    }
}
