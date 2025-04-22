package com.spring6_study.section02_concept_and_implementation_of_di.di.exercise.capsule_coffee_machine_factory;

public class CoffeeMachine {
    private CoffeeCapsule coffeeCapsule;
    public void dripCoffee() {
        coffeeCapsule = new Nespresso();
        System.out.println(coffeeCapsule.extract() + "를 추출합니다.");
    }
}
