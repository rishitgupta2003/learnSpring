package com.rishit.learn_spring_framework.firstSpringTrial;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App{
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println(context.getBean("person2"));

    }
}