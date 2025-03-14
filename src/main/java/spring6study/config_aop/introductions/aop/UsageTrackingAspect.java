package spring6study.config_aop.introductions.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.ComponentScan;

@Aspect
@ComponentScan
public class UsageTrackingAspect {
    @DeclareParents(
            value = "spring6study.config_aop.introductions.service.*+", defaultImpl = DefaultUsageTracked.class)
    public static UsageTracked mixin;

    @Before("execution(* spring6study.config_aop.introductions.service.*.*(..)) && this(usageTracked)")
    public void recordUsage(UsageTracked usageTracked) {
        usageTracked.incrementUseCount();
    }
}
