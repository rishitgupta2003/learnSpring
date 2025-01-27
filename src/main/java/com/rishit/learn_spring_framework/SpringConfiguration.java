package com.rishit.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public String name(){
        return "<Your Name>";
    }

    @Bean
    public Integer age(){
        return 22;
    }

    @Bean
    public Person person(){
        return new Person("Rishit", 21);
    }

    @Bean
    public Address address2(){
        return new Address(
                "B-4/157C",
                "Keshav Puram"
        );
    }

    @Bean
    public Address address3(){
        return new Address(
                "B-58",
                "Subhadra Colony"
        );
    }
}
