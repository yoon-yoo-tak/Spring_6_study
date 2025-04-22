package com.spring6_study.__understanding_bean_scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class ApplicationBean {
    public ApplicationBean() {
        System.out.println("ApplicationBean 생성");
    }
}
