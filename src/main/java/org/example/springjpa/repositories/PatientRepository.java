package org.example.springjpa.repositories;

import org.example.springjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    Patient findByNomContains(String mc);
    List<Patient> findAll();
    void deletePatientByNom(String nom);
}
