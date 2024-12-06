package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entites.Universite;

public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    Universite findByNomUniversite(String nom);
    Universite findByIdUniversite(long id);
}
