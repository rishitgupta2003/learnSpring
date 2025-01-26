package com.rishit.learn_spring_framework.game;

public class GameRunner {
    private GameConsole game;

    public GameRunner(GameConsole game) {
        this.game = game;
    }

    public void run(){
        System.out.println(this.game);
    }

    public GameConsole getGame() {
        return game;
    }
}
