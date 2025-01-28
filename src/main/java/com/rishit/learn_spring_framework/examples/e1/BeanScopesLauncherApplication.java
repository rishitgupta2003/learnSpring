package com.rishit.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
class NormalClass{

}


@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{

    private Boolean state;

    public PrototypeClass(){
        this.state = true;
    }

    public PrototypeClass setState(Boolean state){
        this.state = state;
        return this;
    }

    public Boolean getState() {
        return state;
    }
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {
        try
        (
            var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);
        )
        {

        }
    }
}
