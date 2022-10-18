package com.carloscastaneda.ciclo3.Servicio;

import java.util.List;
import java.util.Optional;

import com.carloscastaneda.ciclo3.Modelo.Game;
import com.carloscastaneda.ciclo3.Repositorio.GameRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class GameServicio {
       @Autowired
    private GameRepositorio gameRepositorio;

    public List<Game> getAll(){
        return gameRepositorio.getAll();
    }

    public Optional<Game> getGame(int gameId) {
        return gameRepositorio.getGame(gameId);
    }

    public Game save(Game game){
        if(game.getId()==null){
            return gameRepositorio.save(game);
        }else{
            Optional<Game>e= gameRepositorio.getGame(game.getId());
            if(e.isEmpty()){
                return gameRepositorio.save(game);
            }else{
                return game;
            }
        }
    }
    
       public Game update(Game game){
        if(game.getId()!=null){
            Optional<Game> e= gameRepositorio.getGame(game.getId());
            if(!e.isEmpty()){
                if(game.getName()!=null){
                    e.get().setName(game.getName());
                }
                if(game.getHotel()!=null){
                    e.get().setHotel(game.getHotel());
                }
                if(game.getStars()!=null){
                    e.get().setStars(game.getStars());
                }
                if(game.getDescription()!=null){
                    e.get().setDescription(game.getDescription());
                }
                if(game.getCategory()!=null){
                    e.get().setCategory(game.getCategory());
                }
                gameRepositorio.save(e.get());
                return e.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }

    
    
      public boolean deleteGame (int id){
        Boolean d = getGame(id).map(room -> {
            gameRepositorio.delete(room);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}
