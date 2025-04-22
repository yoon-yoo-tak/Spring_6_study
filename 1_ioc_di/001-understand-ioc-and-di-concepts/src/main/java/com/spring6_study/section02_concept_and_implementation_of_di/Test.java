package com.spring6_study.section02_concept_and_implementation_of_di;

import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    public void test() {
        DefaultSingletonBeanRegistry defaultSingletonBeanRegistry = new DefaultSingletonBeanRegistry();
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        DefaultListableBeanFactory defaultListableBeanFactory1 = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext();
    }
}
