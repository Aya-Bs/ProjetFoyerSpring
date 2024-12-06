package tn.esprit.tpfoyer.sevices.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entites.Foyer;
import tn.esprit.tpfoyer.entites.Universite;
import tn.esprit.tpfoyer.repositories.IFoyerRepository;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;
import tn.esprit.tpfoyer.sevices.interfaces.IUniversiteService;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IFoyerRepository foyerRepository;

    @Override
    public List<Universite> readAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite readById(long id) {
        return universiteRepository.findById(id).orElse(new Universite());
    }

    @Override
    public Universite create(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Boolean delete(long id) {
        if(universiteRepository.existsById(id))
        {
            universiteRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if(universite != null){
            Foyer foyer = foyerRepository.findByIdFoyer(idFoyer);
            if (foyer != null){
                universite.setFoyer(foyer);
                return universiteRepository.save(universite);
            }
        }
        return null;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findByIdUniversite(idUniversite);
        if (universite != null){
            universite.setFoyer(null);
            return universiteRepository.save(universite);
        }
        return null;
    }
}
