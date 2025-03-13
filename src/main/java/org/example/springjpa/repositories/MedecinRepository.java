package org.example.springjpa.repositories;

import org.example.springjpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Medecin findByNom(String nom);
}
