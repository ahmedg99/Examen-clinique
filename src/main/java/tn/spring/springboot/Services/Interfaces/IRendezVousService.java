package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.RendezVous;
import tn.spring.springboot.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface IRendezVousService {

    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);

    public int getNbrRendezVousMedecin(Long idMedecin);

}
