package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.ICliniqueService;
import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.repositories.CliniqueRepository;


@Service
@Slf4j
public class CliniqueServiceImpl implements ICliniqueService {

    @Autowired
    CliniqueRepository cliniqueRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        log.info("le clinique : " + clinique.getNomClinique() + " a été ajouté avec succès");
        return cliniqueRepository.save(clinique);
    }

}
