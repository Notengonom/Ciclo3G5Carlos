package com.carloscastaneda.ciclo3.Interface;

import com.carloscastaneda.ciclo3.Modelo.Game;
import org.springframework.data.repository.CrudRepository;


public interface GameInterface extends CrudRepository <Game, Integer> {
    
}
