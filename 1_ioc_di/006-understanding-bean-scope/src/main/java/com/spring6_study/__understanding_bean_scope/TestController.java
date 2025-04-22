package com.spring6_study.__understanding_bean_scope;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final SingletonService singletonService1;
    private final SingletonService singletonService2;
    private final PrototypeService prototypeService1;
    private final PrototypeService prototypeService2;
    private final RequestBean requestBean;
    private final SessionBean sessionBean;
    private final ApplicationBean applicationBean;
    private final WebSocketBean webSocketBean;

    @GetMapping("/singleton")
    public String testSingleton() {
        return "SingletonScope: " + singletonService1 + " | " + singletonService2;
    }
    @GetMapping("/prototype")
    public String testPrototype() {
        return "PrototypeScope: " + prototypeService1 + " | " + prototypeService2;
    }

    @GetMapping("/request")
    public String testRequest() {
        return "RequestScope: " + requestBean;
    }

    @GetMapping("/session")
    public String testSession() {
        return "SessionScope: " + sessionBean;
    }

    @GetMapping("/application")
    public String testApplication() {
        return "ApplicationScope: " + applicationBean;
    }

    @GetMapping("/websocket")
    public String testWebSocket() {
        return "WebSocketScope: " + webSocketBean;
    }
}
