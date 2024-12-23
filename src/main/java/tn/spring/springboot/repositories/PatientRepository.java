package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
