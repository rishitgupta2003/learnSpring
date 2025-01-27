package com.rishit.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacManQualifier")
public class PacMan implements GameConsole{
    @Override
    public void gameMove(String move) {
        switch (move){
            case "up" -> System.out.println("Go UP");
            case "down" -> System.out.println("Go DOWN");
            case "left" -> System.out.println("Go LEFT");
            case "right" -> System.out.println("Go RIGHT");
            default -> System.out.println("Enter valid move");
        }
    }
}
