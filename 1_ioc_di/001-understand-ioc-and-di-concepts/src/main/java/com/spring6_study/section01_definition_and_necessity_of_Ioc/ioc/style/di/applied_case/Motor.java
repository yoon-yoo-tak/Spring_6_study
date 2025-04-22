package com.spring6_study.section01_definition_and_necessity_of_Ioc.ioc.style.di.applied_case;

public class Motor implements PowerTrain{
    @Override
    public void start() {
        System.out.println("모터에 전력을 인가합니다.");
    }

    @Override
    public void stop() {
        System.out.println("모터에 전력을 끊습니다.");
    }
}
