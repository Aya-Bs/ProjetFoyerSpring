package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Chambre;

import java.util.List;
import java.util.Set;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {

    @Query("select b from Bloc b  where b.foyer.universite.nomUniversite = :nom")
    Bloc getBlocByNomUniversite(@Param("nom") String nom);

    List<Bloc> findByFoyerUniversiteNomUniversiteLike(String nomUniversite);
    Bloc findByIdBloc(long id);
    @Query("select b from Bloc b join fetch b.chambres c group by b")
    Set<Bloc> listeChambreParBloc();





}
