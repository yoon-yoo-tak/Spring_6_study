package spring6study.config_aop.service;

import org.springframework.stereotype.Component;

@Component
public class Dependency1 {
    public void work(){
        System.out.println("Dependency1 work...");
    }
}
