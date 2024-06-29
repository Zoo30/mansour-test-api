package com.techsolution.spmicroservice.services;

import com.techsolution.spmicroservice.model.Personnes;
import com.techsolution.spmicroservice.repositories.PersonneRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServicesImpl implements PersonneServices{

    @Autowired
    private final PersonneRepositories personneRepositories;

    public PersonneServicesImpl(PersonneRepositories personneRepositories) {
        this.personneRepositories = personneRepositories;
    }

    @Override
    public Personnes createPersonne(Personnes personnes) {
        return personneRepositories.save(personnes);
    }

    @Override
    public List<Personnes> getAllPersonnes() {
        return personneRepositories.findAll();
    }

    @Override
    public void deletePersonne(Long id) {
        personneRepositories.deleteById(id);
    }

    @Override
    public Personnes getPersonneById(long id) {
        return personneRepositories.findById(id).orElseThrow(() -> new RuntimeException(
                "Personne n'existe pas"
        ))  ;

    }


    public Personnes updatePersonne(Long id, Personnes personnes) {

        Personnes existingPersonnes = personneRepositories.findById(id).orElse(null);
        if (existingPersonnes != null) {
            existingPersonnes.setNom(personnes.getNom());
            existingPersonnes.setPrenom(personnes.getPrenom());
            existingPersonnes.setLogin(personnes.getLogin());
            existingPersonnes.setMdp(personnes.getMdp());
            return personneRepositories.save(existingPersonnes);
        } else {
            throw new RuntimeException("Personne n'existe pas");
        }
    }
}
