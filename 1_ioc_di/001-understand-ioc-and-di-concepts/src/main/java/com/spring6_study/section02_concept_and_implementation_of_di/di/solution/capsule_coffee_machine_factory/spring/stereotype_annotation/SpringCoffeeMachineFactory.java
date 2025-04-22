package com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.stereotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoffeeMachineFactory {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                JavaConfig.class);
        CoffeeMachine coffeeMachine = context.getBean(CoffeeMachine.class);
        coffeeMachine.dripCoffee();
    }
}
