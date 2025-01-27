package com.rishit.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{
    //@Autowired -> Field Based Dependency Injection | Done by using Reflections
    Dependency1 dependency1;
    Dependency2 dependency2;


    //@Autowired -> Constructor Based Dependency Injection | Autowired Annotation not needed
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Construction Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

//    @Autowired -> Setter Based Dependency Injection
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setting 1");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setting 2");
//        this.dependency2 = dependency2;
//    }

    @Override
    public String toString() {
        return "YourBusinessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}

@Component
class Dependency1{

}

@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class DependencyInjectionLauncher {
    public static void main(String[] args) {
        try
        (
                var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncher.class);
        )
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println );
            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
