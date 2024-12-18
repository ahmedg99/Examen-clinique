package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IRendezVousService;
import tn.spring.springboot.entities.Medecin;
import tn.spring.springboot.entities.Patient;
import tn.spring.springboot.entities.RendezVous;
import tn.spring.springboot.entities.Specialite;
import tn.spring.springboot.repositories.MedecinRepository;
import tn.spring.springboot.repositories.PatientRepository;
import tn.spring.springboot.repositories.RendezVousRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RendezVousServiceImpl implements IRendezVousService {

    @Autowired
    RendezVousRepository rdvRepository;

    @Autowired
    MedecinRepository medecinRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        Patient patient = patientRepository.findById(idPatient).orElse(null);
        rdv.setMedecin(medecin);
        rdv.setPatient(patient);
        rdvRepository.save(rdv);
    }


    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rdvRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique, specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rdvRepository.findByMedecinIdMedecin(idMedecin).size();
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        int somme = 0;
        Medecin m = medecinRepository.findById(idMedecin).get();
        for (RendezVous rdv : m.getRdvs()) {
            if (rdv.getDateRdv().after(startDate) && rdv.getDateRdv().before(endDate)) {
                somme += rdv.getMedecin().getPrixConsultation();
            }
        }
        return somme;
    }

    @Scheduled(fixedRate = 30000)
    public void retriveRend_vous() {
        //"!!! NOTE: To test this function, change the date of the RendezVous to a date later than the system date (in 2025, not 2022) !!!"
        System.out.println("Liste des RendezVous : ");
        List<RendezVous> rdvs = rdvRepository.findAll();
        for (RendezVous RendezVous : rdvs) {
            if (RendezVous.getDateRdv().after(new Date()))
                log.info("La liste des RendezVous : " + RendezVous.getDateRdv() + " : Medecin :"
                        + RendezVous.getMedecin().getNomMedecin() + " : Patient :"
                        + RendezVous.getPatient().getNomPatient());
        }
    }

}
