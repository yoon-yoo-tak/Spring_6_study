package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.template_method.car;

public abstract class Car {

    public void templateMethod() {
        startEngine();
        moveFroward();
        stopEngine();
    }

    abstract void startEngine();
    abstract void moveFroward();
    abstract void stopEngine();
}
