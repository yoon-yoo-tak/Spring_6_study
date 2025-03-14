package spring6study.config_aop.combiningPointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // 1. AND (&&) public메서드 중에서 service 패키지 내부의 메서드만 매칭
    @Pointcut("execution(public * *(..)) && within(spring6study.config_aop.combiningPointcut.service..*)")
    public void publicServiceMethod(){}


    @Before("publicServiceMethod()")
    public void logPublicServiceMethod(){
        System.out.println("[AOP] AND 적용 : public 메서드 + Service 패키지");
    }

    // 2. OR (||) - DAO 계층과 Service 계층의 모든 메서드 실행을 매칭
    @Pointcut("execution(* spring6study.config_aop.combiningPointcut.dao.*.*(..)) || " +
            "execution(* spring6study.config_aop.combiningPointcut.service.*.*(..))")
    public void daoOrServiceMethod(){}

    @Before("daoOrServiceMethod()")
    public void logDaoOrServiceMethod(){
        System.out.println("[AOP] OR 적용 : DAO 또는 Service 계층");
    }

    // 3. NOT (!) Service 패키지 내부의 AdminService를 제외한 모든 메서드 실행
    @Pointcut("execution(* spring6study.config_aop.combiningPointcut.service.*.*(..)) && " +
            "!execution(* spring6study.config_aop.combiningPointcut.service.AdminService.*(..))")
    public void serviceExcludingAdmin() {}

    @Before("serviceExcludingAdmin()")
    public void logServiceExcludingAdmin(){
        System.out.println("[AOP] NOT 적용: AdminService 제외한 Service 패키지의 모든 메서드");
    }

}
