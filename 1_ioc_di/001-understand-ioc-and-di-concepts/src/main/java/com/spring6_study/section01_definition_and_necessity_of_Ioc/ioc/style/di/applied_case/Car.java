package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.di.applied_case;

public class Car {
    private final PowerTrain powerTrain;

    public Car(PowerTrain powerTrain) {
        this.powerTrain = powerTrain;
    }
}
