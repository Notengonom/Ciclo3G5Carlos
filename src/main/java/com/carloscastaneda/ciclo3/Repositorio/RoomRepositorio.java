package com.carloscastaneda.ciclo3.Repositorio;


import java.util.List;
import java.util.Optional;

import com.carloscastaneda.ciclo3.Interface.RoomInterface;
import com.carloscastaneda.ciclo3.Modelo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class RoomRepositorio {
    @Autowired
    private RoomInterface roomInterface;
    
      public List<Room> getAll(){
        return (List<Room>) roomInterface.findAll();
    }

    public Optional<Room> getRoom(int id){
        return roomInterface.findById(id);
    }

    public Room save(Room room){
        return roomInterface.save(room);
    }
    
     public void delete(Room room){
         roomInterface.delete(room);
    }
    
     
    
}
