package com.example.demo.Repositorio;

import com.example.demo.Interface.ReservationInterface;
import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan
 */

@Repository

public class ReservationRepository {
    
    @Autowired
    
    private ReservationInterface extencionesCrud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) extencionesCrud.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return extencionesCrud.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return extencionesCrud.save(reservation);
    }
    
    public void delete(Reservation reservation){
        extencionesCrud.delete(reservation);   
    }
    
    //Reto5//
    
    public List<Reservation> getReservationByStatus(String status){
           return extencionesCrud.findAllByStatus(status);
       }
       
       public List<Reservation> informePeriodoTiempoReservas(Date a, Date b ){
           return extencionesCrud.findAllByStartDateAfterAndStartDateBefore(a, b);
       }
       
       public List<CountClient> getTopClient(){
           List<CountClient> res = new ArrayList<>();
           List<Object[]> report = extencionesCrud.countTotalReservationByClient();
           for(int i=0;i<report.size();i++){
               res.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
           }
           return res;
       }
    
   
    
}
