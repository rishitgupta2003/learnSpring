package com.rishit.learn_spring_framework.game;

public class MarioGame implements GameConsole{
    @Override
    public void gameMove(String move) {
        switch (move){
            case "up" -> System.out.println("Jump");
            case "down" -> System.out.println("Down the pipe");
            case "left" -> System.out.println("Move Forward");
            case "right" -> System.out.println("Move Backward");
            default -> System.out.println("Enter valid move");
        }
    }
}
