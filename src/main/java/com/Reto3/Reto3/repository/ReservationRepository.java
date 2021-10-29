/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.repository;

import com.Reto3.Reto3.model.Client;
import com.Reto3.Reto3.model.Reservation;
import com.Reto3.Reto3.reportes.ContadorClientes;
import com.Reto3.Reto3.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author agude
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    public List<Reservation> ReservationStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> ReservacionTiempo(Date one, Date two){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(one, two);
    }
    public List<ContadorClientes> getTopClientes(){
        List <ContadorClientes> res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i<report.size();i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }
}
