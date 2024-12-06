package tn.esprit.tpfoyer.sevices.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entites.Etudiant;
import tn.esprit.tpfoyer.repositories.IEtudiantRepository;
import tn.esprit.tpfoyer.sevices.interfaces.IEtudiantService;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService {
    @Autowired
    IEtudiantRepository etudiantRepository;


    @Override
    public List<Etudiant> readAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant readById(long id) {
        return etudiantRepository.findById(id).orElse(new Etudiant());
    }

    @Override
    public Etudiant create(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Boolean delete(long id) {
        if(etudiantRepository.existsById(id))
        {
            etudiantRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
