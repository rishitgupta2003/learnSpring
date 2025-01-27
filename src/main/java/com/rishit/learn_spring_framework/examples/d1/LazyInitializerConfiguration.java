package com.rishit.learn_spring_framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class A{

}


@Component
@Lazy
class B{
    private A obj;

    public B(A obj) {
        System.out.println("Logic");
        this.obj = obj;
    }

    public void doSomething(){
        System.out.println("Inside Class B");
    }
}

@Configuration
@ComponentScan
public class LazyInitializerConfiguration {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(LazyInitializerConfiguration.class);
        )
        {
            context.getBean(B.class).doSomething();
        }
    }
}
