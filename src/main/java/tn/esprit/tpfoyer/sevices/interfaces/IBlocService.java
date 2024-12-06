package tn.esprit.tpfoyer.sevices.interfaces;

import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Universite;

import java.util.List;

public interface IBlocService {
    List<Bloc> readAll();
    Bloc readById(long id);
    Bloc create(Bloc bloc);
    Bloc update (Bloc bloc);
    Boolean delete(long id);
    List<Bloc> getBlocByNomUniversite(String nom);
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;



}
