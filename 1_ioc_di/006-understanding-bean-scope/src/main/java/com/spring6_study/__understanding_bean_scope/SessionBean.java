package com.spring6_study.__understanding_bean_scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionBean {
    public SessionBean() {
        System.out.println("SessionBean 생성");
    }
}
