package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.template_method.car;

public class Main {
    public static void main(String[] args) {
        Car car = new CarImpl();
        car.templateMethod();
    }
}
