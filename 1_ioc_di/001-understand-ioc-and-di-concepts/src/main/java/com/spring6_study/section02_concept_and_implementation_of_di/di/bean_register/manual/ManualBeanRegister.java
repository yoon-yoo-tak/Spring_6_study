package com.spring6_study.section02_concept_and_implementation_of_di.di.bean_register.manual;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManualBeanRegister {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
