package com.techsolution.spmicroservice.services;

import com.techsolution.spmicroservice.model.Personnes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonneServices  {

    Personnes createPersonne(Personnes personnes);
    Personnes updatePersonne(Long id, Personnes personnes);
    Personnes getPersonneById(long id);
    List<Personnes> getAllPersonnes();
    void deletePersonne(Long id);

}
