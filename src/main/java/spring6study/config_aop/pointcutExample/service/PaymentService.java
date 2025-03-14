package spring6study.config_aop.pointcutExample.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public void processPayment(String amount) {
        System.out.println("결제 처리: " + amount);
    }
}