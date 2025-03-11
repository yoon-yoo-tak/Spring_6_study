package spring6study.config_aop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${hello}")
    private String hello;

    @Value("${hello:default hello}")
    private String defaultHello;

    @GetMapping("/hello")
    public String hello() {
        return hello;
    }
}
