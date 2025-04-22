package com.spring6_study.__singleton_and_thread_safe.exercise.stateful_singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AccountModifier {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AccountModifier.class);
        Account account1 = context.getBean(Account.class);
        Account account2 = context.getBean(Account.class);
        account1.setMoneyAmount(1000L);
        System.out.println("account1 = " + account1.getMoneyAmount());
        account2.setMoneyAmount(2000L);
        System.out.println("account1 = " + account1.getMoneyAmount());
    }
}
