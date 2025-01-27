package com.rishit.learn_spring_framework.game;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Contra implements GameConsole{
    @Override
    public void gameMove(String move) {
        switch (move){
            case "up" -> System.out.println("Jump");
            case "down" -> System.out.println("Duck");
            case "left" -> System.out.println("Move Forward");
            case "right" -> System.out.println("Move Backward");
            case "click" -> System.out.println("Shoot");
            default -> System.out.println("Enter valid move");
        }
    }
}
