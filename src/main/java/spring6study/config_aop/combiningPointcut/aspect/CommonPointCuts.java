package spring6study.config_aop.combiningPointcut.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCuts {

    @Pointcut("within(spring6study.config_aop.combiningPointcut.service..*)")
    public void inServiceLayer() {}

    @Pointcut("within(spring6study.config_aop.combiningPointcut.dao..*)")
    public void inDataAccessLayer() {}

    @Pointcut("execution(* spring6study.config_aop.combiningPointcut.service.*.*(..))")
    public void serviceMethod(){}
}
