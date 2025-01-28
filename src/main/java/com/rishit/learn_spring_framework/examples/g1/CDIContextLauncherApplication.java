package com.rishit.learn_spring_framework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Named
class BusinessService{
    DataService dataService;

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setting DataService");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}

//@Component
@Named
class DataService{

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {
    public static void main(String[] args) {
        try(
            var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class);
        )
        {

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
