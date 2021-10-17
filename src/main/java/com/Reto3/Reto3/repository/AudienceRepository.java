/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.repository;

import com.Reto3.Reto3.model.Audience;
import com.Reto3.Reto3.repository.crud.AudienceCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author agude
 */
@Repository
public class AudienceRepository {
    
    @Autowired
    private AudienceCrudRepository audienceCrudRepository;
    
    public List<Audience> getAll(){
        return (List<Audience>) audienceCrudRepository.findAll();
    }
    public Optional<Audience> getAudience(int id){
        return audienceCrudRepository.findById(id);
    }
    public Audience save(Audience audience){
        return audienceCrudRepository.save(audience);
    }
    public void delete(Audience audience){
        audienceCrudRepository.delete(audience);
    }        
}
