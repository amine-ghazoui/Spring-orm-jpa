package org.example.springjpa.service;

import org.example.springjpa.entities.Consultation;
import org.example.springjpa.entities.Medecin;
import org.example.springjpa.entities.Patient;
import org.example.springjpa.entities.RendezVous;

import java.util.List;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


    RendezVous chercherRendezVousParPatient(String nomPatient);

    Patient charcherPatientParNom(String nomPatient);

    Medecin chercherMedecinParNom(String medecinPatient);

    List<Patient> afficherPatients();

    /*
    Patient getPatientByName(String nomPatient);
    void supprimerPatientParNom(String nomPatient);

     */

}
