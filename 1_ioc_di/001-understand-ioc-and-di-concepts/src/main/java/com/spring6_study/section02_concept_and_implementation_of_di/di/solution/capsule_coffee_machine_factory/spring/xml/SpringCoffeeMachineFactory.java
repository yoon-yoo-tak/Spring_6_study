package com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoffeeMachineFactory {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");
        CoffeeMachine coffeeMachine = context.getBean(CoffeeMachine.class);
        coffeeMachine.dripCoffee();
    }
}
