package com.rishit.learn_spring_framework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeComp{
    private SomeDependency someDependency;

    public SomeComp(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("Dependencies are set");
    }

    @PostConstruct
    public void init(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("CleanUp");
    }
}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("Some Logic using Dependency");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("CleanUp");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        try(
            var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)
        )
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
