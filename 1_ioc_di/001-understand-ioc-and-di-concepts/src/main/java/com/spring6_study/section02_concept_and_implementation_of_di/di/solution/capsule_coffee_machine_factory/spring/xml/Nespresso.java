package com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.xml;

import com.spring6_study.section02_concept_and_implementation_of_di.di.exercise.capsule_coffee_machine_factory.CoffeeCapsule;

public class Nespresso implements CoffeeCapsule {
    private String name = "네스프레소";
    @Override
    public String extract() {
        return name;
    }
}
