package com.spring6_study.section03_role_and_working_principle_of_ioc_container.spring_ioc_container.bean_factory;

import com.spring6_study.section02_concept_and_implementation_of_di.di.solution.capsule_coffee_machine_factory.spring.xml.CoffeeMachine;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryExercise {
    public static void main(String[] args) {
        // 1. BeanFactory 생성
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. XML 기반 설정 파일을 로드하는 BeanDefinitionReader 생성
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

        // 3. 빈 가져오기

        // 이름으로 가져오기
        CoffeeMachine coffeeMachine1 = (CoffeeMachine) beanFactory.getBean("coffeeMachine");
        System.out.println("coffeeMachine1 = " + coffeeMachine1);

        // 타입으로 가져오기
        CoffeeMachine coffeeMachine2 = beanFactory.getBean(CoffeeMachine.class);
        System.out.println("coffeeMachine2 = " + coffeeMachine2);

        // 이름 + 타입으로 가져오기
        CoffeeMachine coffeeMachine3 = beanFactory.getBean("coffeeMachine", CoffeeMachine.class);
        System.out.println("coffeeMachine3 = " + coffeeMachine3);

        // 4. 빈 존재 유무 확인하기
        System.out.println("Is contain coffeeMachine Bean : " + beanFactory.containsBean("coffeeMachine"));

        // 5. 빈이 싱글턴인지 확인하기
        boolean isSingleton = beanFactory.isSingleton("coffeeMachine");
        System.out.println("Is Singleton = " + isSingleton);
    }
}
