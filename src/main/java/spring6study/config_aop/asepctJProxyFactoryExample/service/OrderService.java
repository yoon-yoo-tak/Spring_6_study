package spring6study.config_aop.asepctJProxyFactoryExample.service;

public class OrderService {
    public void placeOrder(String item, int quantity) {
        System.out.println("주문 완료: " + item + " - 수량: " + quantity);
    }
}