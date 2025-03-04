package spring6study.config_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyServiceImpl implements MyService {
    private final Dependency1 dependency1;
    private final Dependency2 dependency2;

    @Autowired
    public MyServiceImpl(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething...");
        dependency1.work();
        dependency2.process();
    }
}
