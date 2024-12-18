package tn.spring.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IRendezVousService;
import tn.spring.springboot.entities.RendezVous;
import tn.spring.springboot.entities.Specialite;

import java.util.Date;
import java.util.List;

@RestController("/RendezVous")
public class RendezVousController {

    @Autowired
    IRendezVousService rdvService;

    @PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable("idMedecin") Long idMedecin,
                                             @PathVariable("idPatient") Long idPatient) {
        rdvService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }

    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("idClinique") Long idClinique,
                                                                 @PathVariable("specialite") Specialite specialite) {
        return rdvService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("/getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable("idMedecin") Long idMedecin) {
        return rdvService.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("/getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
                                @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return rdvService.getRevenuMedecin(idMedecin, startDate, endDate);
    }

}
