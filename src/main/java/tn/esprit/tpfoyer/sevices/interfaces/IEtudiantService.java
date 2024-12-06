package tn.esprit.tpfoyer.sevices.interfaces;

import tn.esprit.tpfoyer.entites.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> readAll();
    Etudiant readById(long id);
    Etudiant create(Etudiant etudiant);
    Etudiant update (Etudiant etudiant);
    Boolean delete(long id);
}
