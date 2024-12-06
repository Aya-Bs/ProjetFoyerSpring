package tn.esprit.tpfoyer.sevices.interfaces;

import tn.esprit.tpfoyer.entites.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> readAll();
    Universite readById(long id);
    Universite create(Universite universite);
    Universite update (Universite universite);
    Boolean delete(long id);
    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite(long idUniversite);


}
