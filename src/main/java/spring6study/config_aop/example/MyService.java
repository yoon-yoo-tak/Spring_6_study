package spring6study.config_aop.example;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void doSomething() {
        System.out.println("MyService.doSomething() 실행");
    }

    public String getData() {
        System.out.println("MyService.getData() 실행");
        return "Hello, AOP!";
    }

    public void throwException() {
        System.out.println("MyService.throwException() 실행");
        throw new RuntimeException("예외 발생!");
    }

    public void getString(String str){
        System.out.println("MyService.getString() 실행");
    }
}
