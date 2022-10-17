package com.example.demo.Repositorio;

import com.example.demo.Interface.FarmInterface;
import com.example.demo.Modelo.Farm;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan
 */

@Repository

public class FarmRepository {
    
    @Autowired
    
    private FarmInterface extencionesCrud;
    
    public List<Farm> getAll(){
        return (List<Farm>) extencionesCrud.findAll();
    }
    
    public Optional<Farm> getFarm(int id){
        return extencionesCrud.findById(id);
    }
    
    public Farm save(Farm farm){
        return extencionesCrud.save(farm);
    }
    
    public void delete(Farm farm){
        extencionesCrud.delete(farm);   
    }
    
}
