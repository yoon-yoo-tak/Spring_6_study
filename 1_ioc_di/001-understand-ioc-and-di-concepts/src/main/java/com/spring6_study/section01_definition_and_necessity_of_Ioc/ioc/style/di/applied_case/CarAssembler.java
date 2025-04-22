package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.di.applied_case;

public class CarAssembler {
    public static void main(String[] args) {
        PowerTrain powerTrain = new Engine();
        Car car = new Car(powerTrain);
    }
}
