package com.rishit.learn_spring_framework;

import com.rishit.learn_spring_framework.game.GameConsole;
import com.rishit.learn_spring_framework.game.GameRunner;
import com.rishit.learn_spring_framework.game.PacMan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {
    @Bean
    public GameConsole game(){
        return new PacMan();
    }


    @Bean
    public GameRunner gameRunner(GameConsole game){
        return new GameRunner(game);
    }
}
