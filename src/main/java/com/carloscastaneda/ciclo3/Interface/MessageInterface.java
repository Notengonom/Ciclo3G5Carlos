package com.carloscastaneda.ciclo3.Interface;

import com.carloscastaneda.ciclo3.Modelo.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageInterface extends CrudRepository <Message, Integer> {
    
}
