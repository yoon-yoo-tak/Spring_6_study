package spring6study.config_aop.lifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanOne {

    @PostConstruct
    public void init() {
        System.out.println("BeanOne.init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BeanOne.destroy");
    }
}
