package spring6study.config_aop.asepctJProxyFactoryExample;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import spring6study.config_aop.asepctJProxyFactoryExample.aspect.LoggingAspect;
import spring6study.config_aop.asepctJProxyFactoryExample.service.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderService target = new OrderService();
        AspectJProxyFactory factory = new AspectJProxyFactory(target);
        factory.addAspect(LoggingAspect.class);
        OrderService proxy = factory.getProxy();
        proxy.placeOrder("맥북", 2147483647);
    }
}
