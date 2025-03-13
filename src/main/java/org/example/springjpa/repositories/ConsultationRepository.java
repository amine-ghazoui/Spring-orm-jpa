package org.example.springjpa.repositories;

import org.example.springjpa.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {


}
