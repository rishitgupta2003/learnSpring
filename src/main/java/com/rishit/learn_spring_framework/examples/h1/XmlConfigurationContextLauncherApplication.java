package com.rishit.learn_spring_framework.examples.h1;

import com.rishit.learn_spring_framework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {
        try(
                var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")
        ){
            context.getBean(GameRunner.class).getGame().gameMove("click");
        }
    }
}
