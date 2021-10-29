/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.service;

import com.Reto3.Reto3.model.Audience;
import com.Reto3.Reto3.repository.AudienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agude
 */
@Service
public class AudienceService {
    
    @Autowired
    private AudienceRepository audienceRepository;
    
    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }
    
    public Optional<Audience> getAudience(int id){
        return audienceRepository.getAudience(id);
    }
    
    public Audience save(Audience a){
        if(a.getId()==null){
            return audienceRepository.save(a);
        }
        else{
        Optional<Audience> paux=audienceRepository.getAudience(a.getId());
        if(paux.isEmpty()){
            return audienceRepository.save(a);
        }
        else{
            return a;
        }
        }
    }
    
    public Audience update(Audience audience){
        if(audience.getId()!=null){
            Optional<Audience>guardar=audienceRepository.getAudience(audience.getId());
            if(!guardar.isEmpty()){
                if(audience.getName()!=null){
                    guardar.get().setName(audience.getName());                 
                }
                if(audience.getOwner()!=null){
                    guardar.get().setOwner(audience.getOwner());
                }
                if(audience.getCapacity()!=null){
                    guardar.get().setCapacity(audience.getCapacity());
                }
                if(audience.getDescription()!=null){
                    guardar.get().setDescription(audience.getDescription());
                }
                return audienceRepository.save(guardar.get());
            }
        }
        return audience;
    }
        
    public boolean delete(int id){
        Optional<Audience> audience=getAudience(id);
        if(!audience.isEmpty()){
            audienceRepository.delete(audience.get());
            return true;
        }
        return false;
    }
}
