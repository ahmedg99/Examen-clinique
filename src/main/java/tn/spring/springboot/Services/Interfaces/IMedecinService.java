package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Medecin;

public interface IMedecinService {
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);
}
