package com.spring6_study.section02_concept_and_implementation_of_di.di.bean_register.auto.more_simple_version;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AutoBeanRegister {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoBeanRegister.class);
    }
}
