package com.spring6_study.__singleton_and_thread_safe.exercise.stateful_singleton;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private Long moneyAmount;

    public void setMoneyAmount(Long moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Long getMoneyAmount() {
        return moneyAmount;
    }
}
