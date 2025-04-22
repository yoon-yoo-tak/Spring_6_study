package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.service_locator;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private Map<String, PaymentService> services = new HashMap<>();
    public void register(String serviceName, PaymentService paymentServiceMethod) {
        services.put(serviceName, paymentServiceMethod);
    }
    public PaymentService getService(String serviceName) {
        return services.get(serviceName);
    }
}
