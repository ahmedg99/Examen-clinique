package tn.spring.springboot.Services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IPatientService;
import tn.spring.springboot.entities.Patient;
import tn.spring.springboot.repositories.PatientRepository;


@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
