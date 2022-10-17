package com.carloscastaneda.ciclo3.Interface;

import com.carloscastaneda.ciclo3.Modelo.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientInterface  extends CrudRepository <Client, Integer>{
    
}
