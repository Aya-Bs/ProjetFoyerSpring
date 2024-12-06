package tn.esprit.tpfoyer.sevices.interfaces;

import tn.esprit.tpfoyer.entites.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> readAll();
    Foyer readById(long id);
    Foyer create(Foyer foyer);
    Foyer update (Foyer foyer);
    Boolean delete(long id);
    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;

}
