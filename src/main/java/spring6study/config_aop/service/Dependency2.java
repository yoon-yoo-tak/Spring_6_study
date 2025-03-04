package spring6study.config_aop.service;

import org.springframework.stereotype.Component;

@Component
public class Dependency2 {
    public void process(){
        System.out.println("Dependency2 processing...");
    }
}
