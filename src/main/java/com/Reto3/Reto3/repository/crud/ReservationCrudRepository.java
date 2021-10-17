/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto3.Reto3.repository.crud;

import com.Reto3.Reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author agude
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}
