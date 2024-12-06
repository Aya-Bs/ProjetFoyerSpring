package tn.esprit.tpfoyer.sevices.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entites.Foyer;
import tn.esprit.tpfoyer.entites.Universite;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IFoyerRepository;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;
import tn.esprit.tpfoyer.sevices.interfaces.IFoyerService;
import tn.esprit.tpfoyer.sevices.interfaces.IUniversiteService;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {
    @Autowired
    IFoyerRepository foyerRepository;
    @Autowired
    IUniversiteService universiteService;
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IBlocRepository blocRepository;

    @Override
    public List<Foyer> readAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer readById(long id) {
        return foyerRepository.findById(id).orElse(new Foyer());
    }

    @Override
    public Foyer create(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer update(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Boolean delete(long id) {
        if(foyerRepository.existsById(id))
        {
            foyerRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = universiteRepository.findByIdUniversite(idUniversite);

        Foyer f = foyerRepository.save(foyer);
        universite.setFoyer(f);
        universiteRepository.save(universite);

        return f;
    }
}
