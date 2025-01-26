package com.rishit.learn_spring_framework.game;

public class App {
    public static void main(String[] args) {
        var gameRunner = new GameRunner(
                new Contra()
        );

        gameRunner.run();

        gameRunner.getGame().gameMove("click");
    }
}
