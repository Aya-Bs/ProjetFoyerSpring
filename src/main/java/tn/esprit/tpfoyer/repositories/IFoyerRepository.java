package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entites.Foyer;

public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findByIdFoyer(long id);
}
