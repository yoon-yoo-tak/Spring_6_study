package com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.pojo;

public class PojoCoffeeMachineFactory {
    public static void main(String[] args) {
        CoffeeMachine NespressoCoffeeMachine = new CoffeeMachine(new Nespresso());
        NespressoCoffeeMachine.dripCoffee();
        CoffeeMachine IllyCoffeeMachine = new CoffeeMachine(new Illy());
        IllyCoffeeMachine.dripCoffee();
    }
}
