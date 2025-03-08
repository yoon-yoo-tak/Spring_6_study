package spring6study.config_aop.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

class BeanThree implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() {
        System.out.println("BeanThree 초기화 (afterPropertiesSet)");
    }

    @Override
    public void destroy() {
        System.out.println("BeanThree 소멸 (destroy)");
    }
}