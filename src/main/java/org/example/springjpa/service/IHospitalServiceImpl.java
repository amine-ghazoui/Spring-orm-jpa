package org.example.springjpa.service;

import jakarta.transaction.Transactional;
import org.example.springjpa.entities.Consultation;
import org.example.springjpa.entities.Medecin;
import org.example.springjpa.entities.Patient;
import org.example.springjpa.entities.RendezVous;
import org.example.springjpa.repositories.ConsultationRepository;
import org.example.springjpa.repositories.MedecinRepository;
import org.example.springjpa.repositories.PatientRepository;
import org.example.springjpa.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {

    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    RendezVousRepository rendezVousRepository;
    ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }


    @Override
    public RendezVous chercherRendezVousParPatient(String nomPatient) {

        return rendezVousRepository.findRendezVousByPatientNom(nomPatient);
    }

    @Override
    public Patient charcherPatientParNom(String nomPatient) {
        return patientRepository.findByNomContains(nomPatient);
    }

    @Override
    public Medecin chercherMedecinParNom(String nomMedecin) {
        return medecinRepository.findByNom(nomMedecin);
    }


    @Override
    public List<Patient> afficherPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }
    /*
    @Override
    public Patient getPatientByName(String nomPatient) {

        return patientRepository.findByNomContains(nomPatient);
    }

    @Override
    public void supprimerPatientParNom(String nomPatient) {
        patientRepository.deletePatientByNom(nomPatient);
    }

     */
}
