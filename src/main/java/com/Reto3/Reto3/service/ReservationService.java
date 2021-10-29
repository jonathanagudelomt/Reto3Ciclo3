/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.service;

import com.Reto3.Reto3.model.Reservation;
import com.Reto3.Reto3.reportes.ContadorClientes;
import com.Reto3.Reto3.reportes.StatusReservas;
import com.Reto3.Reto3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agude
 */
/*

*/
@Service
/**
 * 
 */
public class ReservationService {
    /**
     * 
     */
    @Autowired
    /**
     * 
     */
    private ReservationRepository reservationRepository;
    /**
     * 
     * @return 
     */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    /**
     * 
     * @param reservation
     * @return 
     */
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
    /**
     * 
     * @param reservation
     * @return 
     */
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
    /**
     * 
     * @param id
     * @return 
     */ 
    public boolean delete(int id){
        Optional<Reservation> client=getReservation(id);
        if(!client.isEmpty()){
            reservationRepository.delete(client.get());
            return true;
        }
        return false;
    }
    public StatusReservas getReporteStatusReservaciones(){
        List<Reservation>completed=reservationRepository.ReservationStatus("completed");
        List<Reservation>cancelled=reservationRepository.ReservationStatus("cancelled");
        return new StatusReservas(completed.size(),cancelled.size());
        
    }
    
    public List<Reservation> getReportesTiempoReservaciones(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno=new Date();
        Date datoDos=new Date();
        
        try{
            datoUno=parser.parse(dateA);
            datoDos=parser.parse(dateB);
            }catch(ParseException evt){
                evt.printStackTrace();
            }if(datoUno.before(datoDos)){
                return reservationRepository.ReservacionTiempo(datoUno, datoDos);
            }else{
                return new ArrayList<>();
            }          
    }
    
    public List<ContadorClientes> servicioTopClientes(){
        return reservationRepository.getTopClientes();
    }
}
