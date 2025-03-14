package spring6study.config_aop.introductions.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void doTask() {
        System.out.println("MyService: 작업 수행...");
    }
}
