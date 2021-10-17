/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.service;

import com.Reto3.Reto3.model.Reservation;
import com.Reto3.Reto3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agude
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }
        else{
        Optional<Reservation> paux=reservationRepository.getReservation(reservation.getIdReservation());
        if(paux.isEmpty()){
            return reservationRepository.save(reservation);
        }
        else{
            return reservation;
        }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>guardar=reservationRepository.getReservation(reservation.getIdReservation());
            if(!guardar.isEmpty()){
                if(reservation.getStartDate()!=null){
                    guardar.get().setStartDate(reservation.getStartDate());
                 
                }
                if(reservation.getDevolutionDate()!=null){
                    guardar.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    guardar.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(guardar.get());
            }
        }
        return reservation;
    }
        
    public boolean delete(int id){
        Optional<Reservation> client=getReservation(id);
        if(!client.isEmpty()){
            reservationRepository.delete(client.get());
            return true;
        }
        return false;
    }    
}
