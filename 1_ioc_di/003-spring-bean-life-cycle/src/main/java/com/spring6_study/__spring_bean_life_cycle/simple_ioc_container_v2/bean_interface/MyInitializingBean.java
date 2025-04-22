package com.spring6_study.__spring_bean_life_cycle.simple_ioc_container_v2.bean_interface;

public interface MyInitializingBean {
    void afterPropertiesSet() throws Exception;
}
