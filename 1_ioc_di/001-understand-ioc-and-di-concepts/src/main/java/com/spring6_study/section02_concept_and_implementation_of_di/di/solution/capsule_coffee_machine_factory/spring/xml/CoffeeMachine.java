package com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.xml;

import com.spring6_study.section02_concept_and_implementation_of_di.di.exercise.capsule_coffee_machine_factory.CoffeeCapsule;
public class CoffeeMachine {
    private final CoffeeCapsule coffeeCapsule;

    public CoffeeMachine(CoffeeCapsule coffeeCapsule) {
        this.coffeeCapsule = coffeeCapsule;
    }
    public void dripCoffee() {
        System.out.println(coffeeCapsule.extract() + "를 추출합니다. 맛있게 드세요.");
    }
}
