package com.spring6_study.__understanding_bean_scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean {
    public RequestBean() {
        System.out.println("RequestBean 생성");
    }
}
