package com.carloscastaneda.ciclo3.Interface;

import com.carloscastaneda.ciclo3.Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationInterface extends CrudRepository <Reservation, Integer> {
    
}
