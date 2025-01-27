package com.rishit.learn_spring_framework.game;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GameConsole game;

    public GameRunner(@Qualifier("PacManQualifier") GameConsole game) {
        this.game = game;
    }

    public void run(){
        System.out.println(this.game);
    }

    public GameConsole getGame() {
        return game;
    }
}
