package com.carloscastaneda.ciclo3.Interface;

import com.carloscastaneda.ciclo3.Modelo.Room;
import org.springframework.data.repository.CrudRepository;


public interface RoomInterface extends CrudRepository <Room, Integer> {
    
}
