package com.techsolution.spmicroservice.repositories;

import com.techsolution.spmicroservice.model.Personnes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepositories extends JpaRepository<Personnes, Long>{

}
