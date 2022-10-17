package com.carloscastaneda.ciclo3.Servicio;

import java.util.List;
import java.util.Optional;

import com.carloscastaneda.ciclo3.Modelo.Room;
import com.carloscastaneda.ciclo3.Repositorio.RoomRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class RoomServicio {
       @Autowired
    private RoomRepositorio roomRepositorio;

    public List<Room> getAll(){
        return roomRepositorio.getAll();
    }

    public Optional<Room> getRoom(int ortopedicId) {
        return roomRepositorio.getRoom(ortopedicId);
    }

    public Room save(Room room){
        if(room.getId()==null){
            return roomRepositorio.save(room);
        }else{
            Optional<Room>e= roomRepositorio.getRoom(room.getId());
            if(e.isEmpty()){
                return roomRepositorio.save(room);
            }else{
                return room;
            }
        }
    }
    
       public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> e= roomRepositorio.getRoom(room.getId());
            if(!e.isEmpty()){
                if(room.getName()!=null){
                    e.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    e.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    e.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    e.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    e.get().setCategory(room.getCategory());
                }
                roomRepositorio.save(e.get());
                return e.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }

    
    
      public boolean deleteRoom (int id){
        Boolean d = getRoom(id).map(room -> {
            roomRepositorio.delete(room);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}
