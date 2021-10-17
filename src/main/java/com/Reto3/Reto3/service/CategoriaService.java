/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.service;

import com.Reto3.Reto3.model.Categoria;
import com.Reto3.Reto3.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agude
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> getAll(){
        return categoriaRepository.getAll();
    }
    
    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }
    
    public Categoria save(Categoria a){
        if(a.getId()==null){
            return categoriaRepository.save(a);
        }
        else{
        Optional<Categoria> paux=categoriaRepository.getCategoria(a.getId());
        if(paux.isEmpty()){
            return categoriaRepository.save(a);
        }
        else{
            return a;
        }
        }
    }
    
    public Categoria update(Categoria category){
        if(category.getId()!=null){
            Optional<Categoria>guardar=categoriaRepository.getCategoria(category.getId());
            if(!guardar.isEmpty()){
                if(category.getName()!=null){
                    guardar.get().setName(category.getName());                 
                }
                if(category.getDescription()!=null){
                    guardar.get().setDescription(category.getDescription());
                }                
                return categoriaRepository.save(guardar.get());
            }
        }
        return category;
    }
        
    public boolean delete(int id){
        Optional<Categoria> categoria=getCategoria(id);
        if(!categoria.isEmpty()){
            categoriaRepository.delete(categoria.get());
            return true;
        }
        return false;
    }    
}

