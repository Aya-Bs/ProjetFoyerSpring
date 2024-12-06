package tn.esprit.tpfoyer.repositories;

import jakarta.persistence.SecondaryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entites.Chambre;
import tn.esprit.tpfoyer.entites.TypeChambre;

import java.util.List;
import java.util.Set;


public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    @Query(value = "select count(r) from Chambre c join c.reservations r where c.numeroChambre > 10")
    int getReservationNbr();
    Chambre findByIdChambre(long id);
    List<Chambre> findChambresByBloc_IdBloc(long idBloc);
    List<Chambre> findByBloc_IdBlocAndAndTypeC(long idBloc, TypeChambre typeC);

    @Query("select c from Chambre c where c.bloc.idBloc = :idBloc and c.typeC = :typeC")
    List<Chambre> getParBlocEtType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    @Query(" select c from Chambre c JOIN  Reservation r on(r not member of c.reservations) " +
            "where (c.bloc.idBloc = :idBloc and (year (r.anneeUniversitaire) = year (current date ) ))  " +
            "order by c.idChambre limit 1")
    Chambre getChambreForReservation( long idBloc);

    @Query("select c from Chambre c join Reservation r on (r member of c.reservations) where r.idResevation = :idRes")
    Chambre findByIdReservation(String idRes);




}
