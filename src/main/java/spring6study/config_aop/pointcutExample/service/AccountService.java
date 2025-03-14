package spring6study.config_aop.pointcutExample.service;

import org.springframework.stereotype.Service;
import spring6study.config_aop.pointcutExample.Loggable;
import spring6study.config_aop.pointcutExample.Secure;

@Service
public class AccountService {
    public void createAccount(){
        System.out.println("Account 생성");
    }

    @Loggable
    public void loggableMethod(){
        System.out.println("Loggable 어노테이션이 있는 메서드 실행");
    }

    public void secureTransaction(@Secure String transactionId) {
        System.out.println("Secure Transaction 실행: " + transactionId);
    }
}
