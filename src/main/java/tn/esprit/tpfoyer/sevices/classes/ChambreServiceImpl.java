package tn.esprit.tpfoyer.sevices.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Chambre;
import tn.esprit.tpfoyer.entites.TypeChambre;
import tn.esprit.tpfoyer.entites.Universite;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IChambreRepository;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;
import tn.esprit.tpfoyer.sevices.interfaces.IChambreService;

import java.util.*;

@Service
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    IChambreRepository chambreRepository;
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IBlocRepository blocRepository;


    @Override
    public List<Chambre> readAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre readById(long id) {
        return chambreRepository.findById(id).orElse(new Chambre());
    }

    @Override
    public Chambre create(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre update( Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Boolean delete(long id) {
        if (chambreRepository.existsById(id)) {
            chambreRepository.deleteById(id);
            return true;
        } else
            return false;

    }
    public int getReservationNbr(){
        return chambreRepository.getReservationNbr();
    }
   public List<Chambre> findChambresByBloc(long idBloc){
        return chambreRepository.findChambresByBloc_IdBloc(idBloc).stream().toList();

    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Set<Bloc> blocSet = new HashSet<>(universite.getFoyer().getBlocs()) ;
        List<Chambre> chambres = new ArrayList<>();
        for(Bloc b : blocSet){
           chambres = b.getChambres().stream().toList();
        }
        return chambres;
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeKeyword(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBloc_IdBlocAndAndTypeC(idBloc,typeC);
    }

    @Override
    public List<Chambre> getParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.getParBlocEtType(idBloc,typeC);
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void listeChambreParBloc() {
        Set <Chambre> chambres = chambreRepository.listeChambreParBloc();

        for (Chambre c : chambres){
            System.out.println("Bloc "+c.getBloc() + "capacité :" + c.getBloc().getCapaciteBloc());
            System.out.println("num chambre :" + c.getNumeroChambre());
            System.out.println("type "+ c.getTypeC());
        }

    }
    //@Scheduled(fixedRate = 60000)
    @Override
    public void listeChambreParBlocFromBloc() {
        Set <Bloc> blocs = blocRepository.listeChambreParBloc();

        for (Bloc b : blocs){
            System.out.println();
            System.out.println("Bloc "+b.getNomBloc() + "capacité :" + b.getNomBloc());
            for(Chambre c : blocs.stream().iterator().next().getChambres()){
                System.out.println("num chambre :" + c.getNumeroChambre());
                System.out.println("type "+ c.getTypeC());
            }

        }

    }

    @Override
    public void pourcentageChambreParTypeChambre() {
        int nbr = chambreRepository.nbrChambres();
        List <Chambre> chambres = this.readAll();
        List<TypeChambre> types = Collections.singletonList(chambres.listIterator().next().getTypeC());
            for (TypeChambre tc : types){
                //float pourcentage = (tc * ) / nbr;


            }

    }
}
