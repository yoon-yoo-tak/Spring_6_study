package com.spring6_study.section02_concept_and_implementation_of_di.di.bean_register.auto.use_extra_java_config_class;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoBeanRegister {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
