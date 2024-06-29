package com.techsolution.spmicroservice.controler;

import com.techsolution.spmicroservice.model.Personnes;
import com.techsolution.spmicroservice.services.PersonneServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonnesControler {

    private PersonneServices personneServices;

    public PersonnesControler(PersonneServices personneServices) {
        this.personneServices = personneServices;
    }

    @GetMapping("/allpersonnes")
    public List<Personnes> getAllPersonnes() {
        return personneServices.getAllPersonnes();
    }

    @GetMapping("/personne/{id}")
    public Personnes getPersonneById(@PathVariable Long id) {
        return personneServices.getPersonneById(id);
    }

    @PostMapping("/create")
    public Personnes createPersonne(@RequestBody Personnes personnes) {
        return personneServices.createPersonne(personnes);
    }

    @PutMapping("/update/{id}")
    public Personnes updatePersonne(@PathVariable Long id, @RequestBody Personnes personnes) {
        return personneServices.updatePersonne(id, personnes);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonne(@PathVariable Long id) {
        personneServices.deletePersonne(id);
    }

}
