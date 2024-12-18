package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IMedecinService;
import tn.spring.springboot.entities.Clinique;
import tn.spring.springboot.entities.Medecin;
import tn.spring.springboot.repositories.CliniqueRepository;
import tn.spring.springboot.repositories.MedecinRepository;

import javax.transaction.Transactional;

@Service
@Slf4j
public class MedecinServiceImpl implements IMedecinService {

    @Autowired
    CliniqueRepository cliniqueRepository;

    @Autowired
    MedecinRepository medecinRepository;

    @Override
    @Transactional
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);
        clinique.getMedecins().add(medecin);
        log.info("le medecin : " + medecin.getNomMedecin() + " a été ajouté avec succès à la clinique : " + clinique.getNomClinique());
        return medecinRepository.save(medecin);
    }

}
