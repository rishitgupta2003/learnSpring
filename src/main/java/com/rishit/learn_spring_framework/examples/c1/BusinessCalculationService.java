package com.rishit.learn_spring_framework.examples.c1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    private DataService service;

    @Autowired
    public BusinessCalculationService(@Qualifier("mySQL_DataService") DataService service) {
        this.service = service;
    }

    public int findMax(){
        return Arrays.stream(service.retrieveData()).max().getAsInt();
    }
}
