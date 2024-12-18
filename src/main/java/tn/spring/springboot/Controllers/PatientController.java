package tn.spring.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.spring.springboot.Services.Interfaces.IPatientService;
import tn.spring.springboot.entities.Patient;


@RestController("/patient")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping("/add-patient")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }
}
