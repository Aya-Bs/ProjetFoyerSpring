package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Etudiant;

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByCin(long cin);
}
