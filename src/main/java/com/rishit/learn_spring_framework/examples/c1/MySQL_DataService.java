package com.rishit.learn_spring_framework.examples.c1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class MySQL_DataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{
                3,346,4365,36,6,3,24,14,123,123,13,12,1,43,434
        };
    }
}
