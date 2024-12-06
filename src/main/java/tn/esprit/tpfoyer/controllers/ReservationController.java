package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Reservation;
import tn.esprit.tpfoyer.sevices.interfaces.IReservationService;

import java.util.List;
@Tag(name = "Gestion Reservation")
@RestController
@RequestMapping("api/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @GetMapping("get-all")
    @Operation(summary = "get all entities", description = "get all entities")
    public List<Reservation> readAll(){
        return reservationService.readAll();
    }
    @GetMapping("get-by-id/{id}")
    @Operation(summary = "get an entity by id" , description = "get an entity by id")
    Reservation readById(@PathVariable int id){
        return reservationService.readById(id);
    }
    @PostMapping("add")
    @Operation(summary = "add an entity" , description = "add an entity")
    Reservation create(@RequestBody Reservation reservation){

        return reservationService.create(reservation);
    }
    @PutMapping("update")
    @Operation(summary ="update an entity" ,description = "update an entity")
    Reservation update (@RequestBody Reservation reservation){

        return reservationService.update(reservation);
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary ="delete an entity" ,description = "delete an entity")
    Boolean delete(@PathVariable int id){

        return reservationService.delete(id);
    }
    @PostMapping("ajouterReservation")
    @Operation(summary = "add an entity" , description = "add an entity")
    public Reservation ajouterReservation( long idBloc, long cinEtudiant){
        return reservationService.ajouterReservation(idBloc,cinEtudiant);
    }


}
