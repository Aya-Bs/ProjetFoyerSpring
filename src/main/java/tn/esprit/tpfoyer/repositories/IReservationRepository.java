package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entites.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r join Chambre c on (r member of c.reservations)  where (c.bloc.idBloc = :idBloc and year(r.anneeUniversitaire) = year(current date) and r.estValide = true) order by r.idResevation limit 1")
    Reservation getForReservation(@Param("idBloc") long idBloc );
}
