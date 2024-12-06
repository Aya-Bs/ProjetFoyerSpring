package tn.esprit.tpfoyer.sevices.interfaces;

import tn.esprit.tpfoyer.entites.Chambre;
import tn.esprit.tpfoyer.entites.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> readAll();
    Chambre readById(long id);
    Chambre create(Chambre chambre);
    Chambre update (Chambre chambre);
    Boolean delete(long id);
    int getReservationNbr();
    List<Chambre> findChambresByBloc(long idBloc);
    List<Chambre>  getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtTypeKeyword (long idBloc, TypeChambre typeC) ;
    public List<Chambre> getParBlocEtType (long idBloc, TypeChambre typeC) ;




}
