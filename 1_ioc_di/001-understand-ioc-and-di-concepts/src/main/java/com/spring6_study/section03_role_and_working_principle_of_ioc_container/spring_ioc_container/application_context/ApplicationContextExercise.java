package com.spring6_study.section03_role_and_working_principle_of_ioc_container.spring_ioc_container.application_context;

import com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.java_configuration.CoffeeMachine;
import com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.java_configuration.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExercise {
    public static void main(String[] args) {
        // 1. ApplicationContext 생성
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        // 2. Bean 가져오기
        CoffeeMachine coffeeMachine = context.getBean(CoffeeMachine.class);
        System.out.println("coffeeMachine = " + coffeeMachine);
    }
}
