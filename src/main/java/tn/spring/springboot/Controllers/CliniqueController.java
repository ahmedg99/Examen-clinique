package tn.spring.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.spring.springboot.Services.Interfaces.ICliniqueService;
import tn.spring.springboot.entities.Clinique;


@RestController("/clinique")
public class CliniqueController {

    @Autowired
    ICliniqueService cliniqueService;

    @PostMapping("/add_clinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return cliniqueService.addClinique(clinique);
    }


}
