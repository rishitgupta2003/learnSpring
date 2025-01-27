package com.rishit.learn_spring_framework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDB_DataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{
                1,2,3,4,6,8,9,43,3,1,312,41,41,5325,35,35,325,325,325,325,221
        };
    }
}
