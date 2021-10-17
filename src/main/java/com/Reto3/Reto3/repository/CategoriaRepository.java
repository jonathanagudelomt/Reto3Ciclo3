/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.repository;

import com.Reto3.Reto3.model.Categoria;
import com.Reto3.Reto3.repository.crud.CategoriaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author agude
 */
@Repository
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return categoriaCrudRepository.findById(id);
    }
    public Categoria save(Categoria categoria){
        return categoriaCrudRepository.save(categoria);
    }
    public void delete(Categoria categoria){
        categoriaCrudRepository.delete(categoria);
    }
}

