package org.example.springjpa.repositories;

import org.example.springjpa.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    RendezVous findRendezVousByPatientNom(String patientName);

}
