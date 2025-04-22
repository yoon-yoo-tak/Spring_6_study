package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.template_method.car;

public class CarImpl extends Car {
    @Override
    void startEngine() {
        System.out.println("차량의 시동을 겁니다.");
    }

    @Override
    void moveFroward() {
        System.out.println("차량을 앞으로 움직입니다.");
    }

    @Override
    void stopEngine() {
        System.out.println("차량의 시동을 끕니다.");
    }
}
