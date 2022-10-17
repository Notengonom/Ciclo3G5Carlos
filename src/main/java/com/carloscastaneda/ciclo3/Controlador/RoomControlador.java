package com.carloscastaneda.ciclo3.Controlador;

import java.util.List;
import java.util.Optional;

import com.carloscastaneda.ciclo3.Modelo.Room;
import com.carloscastaneda.ciclo3.Servicio.RoomServicio;
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
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*")

public class RoomControlador {
     @Autowired
    private RoomServicio roomservice;
    @GetMapping("/all")
    public List<Room> getRooms(){
        return roomservice.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int roomId) {
        return roomservice.getRoom(roomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room) {
        return roomservice.save(room);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room) {
        return roomservice.update(room);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return roomservice.deleteRoom(id);
    }
    
  
}
