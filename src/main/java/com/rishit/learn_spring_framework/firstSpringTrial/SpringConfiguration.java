package com.rishit.learn_spring_framework.firstSpringTrial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
        return new Person("Rishit", 21, new Address("", ""));
    }

    @Bean
    public Person person2(String name, Integer age, @Qualifier("Old Place") Address address2){
        return new Person(
                name,
                age,
                address2
        );
    }

    @Bean @Primary @Qualifier("Old Place")
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
