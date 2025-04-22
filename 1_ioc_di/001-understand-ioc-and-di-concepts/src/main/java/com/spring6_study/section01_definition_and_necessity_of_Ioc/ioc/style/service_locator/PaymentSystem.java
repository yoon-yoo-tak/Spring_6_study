package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.service_locator;

public class PaymentSystem {
    public static void main(String[] args) {
        ServiceLocator serviceLocator = new ServiceLocator();
        serviceLocator.register("CreditCard", new CreditCardPaymentService());
        serviceLocator.register("PayPal", new PaypalPaymentService());

        PaymentService creditCard = serviceLocator.getService("CreditCard");
        creditCard.pay(10000L);
        PaymentService payPal = serviceLocator.getService("PayPal");
        payPal.pay(20000L);
    }
}
