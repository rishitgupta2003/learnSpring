package com.rishit.learn_spring_framework;

import com.rishit.learn_spring_framework.game.GameConsole;
import com.rishit.learn_spring_framework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        try(
            var context = new AnnotationConfigApplicationContext(
                    GameConfiguration.class
            )
        ){
            context.getBean(GameConsole.class).gameMove("up");
            context.getBean(GameRunner.class).getGame().gameMove("Click");
        }
    }
}
