package com.carloscastaneda.ciclo3.Interface;

import com.carloscastaneda.ciclo3.Modelo.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryInterface extends CrudRepository <Category, Integer>{
    
}
