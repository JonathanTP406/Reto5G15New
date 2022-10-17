package com.example.demo.Servicio;

import com.example.demo.Modelo.Farm;
import com.example.demo.Repositorio.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan
 */

@Service
public class FarmService {
    @Autowired
    
    private FarmRepository farmRepository;
    
    public List<Farm> getAll(){
        return farmRepository.getAll();
    }
    
    public Optional<Farm> getFarm(int id){
        return farmRepository.getFarm(id);    
    }
    
    public Farm save (Farm farm){
        if(farm.getId() == null){
            return farmRepository.save(farm);
        } else {
            Optional<Farm> farm1 = farmRepository.getFarm(farm.getId());
            if (farm1.isEmpty()){
                return farmRepository.save(farm);
            }else{
                return farm;
            }
        }
    }
    
    public Farm update(Farm farm){
        if(farm.getId()!=null){
            Optional<Farm> e= farmRepository.getFarm(farm.getId());
            if(!e.isEmpty()){
                if(farm.getName()!=null){
                    e.get().setName(farm.getName());
                }
                if(farm.getAddress()!=null){
                    e.get().setAddress(farm.getAddress());
                }
                if(farm.getExtension()!=null){
                    e.get().setExtension(farm.getExtension());
                }
                if(farm.getDescription()!=null){
                    e.get().setDescription(farm.getDescription());
                }
                if(farm.getCategory()!=null){
                    e.get().setCategory(farm.getCategory());
                }
                farmRepository.save(e.get());
                return e.get();
            }else{
                return farm;
            }
        }else{
            return farm;
        }
    }
    
    
    public boolean deleteFarm(int id){
        Boolean d = getFarm(id).map(farm -> {
              farmRepository.delete(farm);
              return true;
    }).orElse(false);
    return d;
    }
}
