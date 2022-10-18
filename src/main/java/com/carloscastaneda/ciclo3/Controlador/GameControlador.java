package com.carloscastaneda.ciclo3.Controlador;

import java.util.List;
import java.util.Optional;

import com.carloscastaneda.ciclo3.Modelo.Game;
import com.carloscastaneda.ciclo3.Servicio.GameServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*")

public class GameControlador {
     @Autowired
    private GameServicio roomservice;
    @GetMapping("/all")
    public List<Game> getRooms(){
        return roomservice.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Game> getRoom(@PathVariable("id") int roomId) {
        return roomservice.getRoom(roomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game) {
        return roomservice.save(game);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@RequestBody Game game) {
        return roomservice.update(game);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return roomservice.deleteRoom(id);
    }
    
  
}
