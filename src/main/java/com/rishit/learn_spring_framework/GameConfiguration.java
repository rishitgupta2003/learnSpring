package com.rishit.learn_spring_framework;

import com.rishit.learn_spring_framework.game.GameConsole;
import com.rishit.learn_spring_framework.game.GameRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration @ComponentScan("com.rishit.learn_spring_framework.game")
public class GameConfiguration {
    @Bean
    public GameRunner gameRunner(@Qualifier("pacMan") GameConsole game){
        return new GameRunner(game);
    }
}