package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.di.applied_case;

public class Engine implements PowerTrain{

    @Override
    public void start() {
        System.out.println("엔진에 시동을 겁니다.");
    }

    @Override
    public void stop() {
        System.out.println("엔진에 시동을 끕니다.");
    }
}
