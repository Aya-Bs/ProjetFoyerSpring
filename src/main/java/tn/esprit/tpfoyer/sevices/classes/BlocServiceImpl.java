package tn.esprit.tpfoyer.sevices.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Chambre;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IChambreRepository;
import tn.esprit.tpfoyer.sevices.interfaces.IBlocService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BlocServiceImpl implements IBlocService {
    @Autowired
    IBlocRepository blocRepository;
    @Autowired
    IChambreRepository chambreRepository;
    //List<Bloc> blocs = new ArrayList<>();

    @Override
    public List<Bloc> readAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc readById(long id) {
        return blocRepository.findById(id).orElse(new Bloc());
    }

    @Override
    public Bloc create(Bloc bloc) {

       return blocRepository.save(bloc);

    }

    @Override
    public Bloc update(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    public Boolean delete(long id) {
        if (blocRepository.existsById(id)){
            blocRepository.deleteById(id);
            return true;
        }else
            return false;

    }
    @Override
    public List<Bloc> getBlocByNomUniversite(String nom) {
        return  blocRepository.findByFoyerUniversiteNomUniversiteLike(nom);
        //return blocRepository.getBlocByNomUniversite(nom);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        System.err.println("Service : " +numChambre.toString() +"      "+ idBloc);
        if (blocRepository.existsById(idBloc) && !numChambre.isEmpty() ){
            Bloc bloc = blocRepository.findByIdBloc(idBloc);
            Set<Chambre> chambres =new HashSet<Chambre>( chambreRepository.findAllById(numChambre));
           chambres.forEach(chambre -> {
               chambre.setBloc(bloc);

           });
           chambreRepository.saveAll(chambres);
            return blocRepository.findById(chambres.iterator().next().getBloc().getIdBloc()).get();
        } return null;


    }


}
