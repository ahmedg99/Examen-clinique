package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Clinique;

@Repository
public interface CliniqueRepository extends JpaRepository<Clinique, Long> {

}
