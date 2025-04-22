package com.spring6_study.__understanding_bean_scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebSocketBean {
    public WebSocketBean() {
        System.out.println("WebSocketBean 생성");
    }
}
