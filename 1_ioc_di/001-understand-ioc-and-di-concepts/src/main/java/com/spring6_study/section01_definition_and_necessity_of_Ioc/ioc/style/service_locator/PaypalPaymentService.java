package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.service_locator;

public class PaypalPaymentService implements PaymentService {
    @Override
    public void pay(Long amount) {
        System.out.println(amount + "원을 페이팔로 결제합니다.");
    }
}
