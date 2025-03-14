package spring6study.config_aop.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Value("${server.port:8080}")
    private String port;

    @PostConstruct
    public void printPort(){
        System.out.println("server port : " + port);
    }
}
