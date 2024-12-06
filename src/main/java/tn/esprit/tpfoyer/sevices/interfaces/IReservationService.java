package tn.esprit.tpfoyer.sevices.interfaces;

import tn.esprit.tpfoyer.entites.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> readAll();
    Reservation readById(long id);
    Reservation create(Reservation reservation);
    Reservation update (Reservation reservation);
    Boolean delete(long id);
    Reservation ajouterReservation (long idBloc, long cinEtudiant) ;
    Reservation annulerReservation (long cinEtudiant) ;

}
