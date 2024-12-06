package tn.esprit.tpfoyer.sevices.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entites.*;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IChambreRepository;
import tn.esprit.tpfoyer.repositories.IEtudiantRepository;
import tn.esprit.tpfoyer.repositories.IReservationRepository;
import tn.esprit.tpfoyer.sevices.interfaces.IReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    IReservationRepository reservationRepository;
    @Autowired
    IBlocRepository blocRepository;
    @Autowired
    IEtudiantRepository etudiantRepository;
    @Autowired
    IChambreRepository chambreRepository;

    @Override
    public List<Reservation> readAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation readById(long id) {
        return reservationRepository.findById(id).orElse(new Reservation());
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Boolean delete(long id) {
        if(reservationRepository.existsById(id))
        {
            reservationRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Etudiant e = etudiantRepository.findByCin(cinEtudiant);
        if( e != null){
            Reservation r = reservationRepository.getForReservation(idBloc);
            if( r != null){
                r.getEtudiants().add(e);
                Chambre c = chambreRepository.findByIdReservation(r.getIdResevation());
                if ( c.getTypeC() == TypeChambre.DOUBLE || (c.getTypeC()== TypeChambre.TRIPLE && r.getEtudiants().size()==3)){
                    r.setEstValide(false);
                }
                return reservationRepository.save(r);
            }
            else {
               Chambre c = chambreRepository.getChambreForReservation(idBloc);
               Reservation r1 = Reservation.builder().idResevation(c.getNumeroChambre()+"-" +c.getBloc().getNomBloc()+"-"+getAnneeUniversitaire()).anneeUniversitaire(getAnneeUniversitaire()).etudiants(new HashSet<Etudiant>()).estValide(true).build();
               r1.getEtudiants().add(e);
               if(c.getTypeC()==TypeChambre.SIMPLE)
                   r1.setEstValide(false);
              c.getReservations().add(r1);
              chambreRepository.save(c);
        return reservationRepository.save(r1);
            }
        }
        return new Reservation();
    }


    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        return null;
    }




    public Date getAnneeUniversitaire() {
        String yearString = "2024"; // Example year
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        try {
            return sdf.parse(yearString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
