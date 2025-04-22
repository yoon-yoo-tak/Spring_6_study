package com.spring6_study.__understanding_bean_scope;

import org.springframework.stereotype.Component;

@Component
public class SingletonService {
    public SingletonService() {
        System.out.println("SingletonService 생성");
    }
}
