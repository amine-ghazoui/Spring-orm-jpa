package org.example.springjpa;

import org.example.springjpa.entities.*;
import org.example.springjpa.service.IHospitalServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringJpaApplication  {

    public static void main(String[] args) {

        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IHospitalServiceImpl service) {
        return args -> {

            // Ajouter des patients
            service.savePatient(new Patient(null, "Hssayn", new Date(), false, 12, null));
            service.savePatient(new Patient(null, "Hmad", new Date(), true, 34, null));
            service.savePatient(new Patient(null, "Moloud", new Date(), true, 65, null));
            service.savePatient(new Patient(null, "Rkiya", new Date(), false, 78, null));

            System.out.println("***********************************");

            // Ajouter des Medecins
            Stream.of("Mostapha", "Ibtissame", "Soufiane").forEach(name -> {

                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"123@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio": "Dentiste");
                service.saveMedecin(medecin);
            });

            System.out.println("***********************************");

            // Ajouter des Rendez-Vous

            Patient patient = service.charcherPatientParNom("Hssayn");
            Medecin medecin = service.chercherMedecinParNom("Ibtissame");
            service.saveRDV(new RendezVous(null, new Date(), StatusRDV.PENDING, patient, medecin, null));

            System.out.println("***********************************");
            // Ajouter des Consultations

            RendezVous rdvP1 = service.chercherRendezVousParPatient("Hmad");
            RendezVous rdvP2 = service.chercherRendezVousParPatient("Moloud");
            service.saveConsultation(new Consultation(null, new Date(), "bon santé", rdvP1));
            service.saveConsultation(new Consultation(null, new Date(), "malade", rdvP2));

            System.out.println("***********************************");



            //Consulter tous les patients

            List<Patient> patients = service.afficherPatients();
            patients.forEach( p -> {
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getDateNaissance());
                System.out.println(p.isMalade());
                System.out.println(p.getScore());
                System.out.println("***********************************");
            });

            System.out.println("***********************************");
            /*
            // Consulter un patient

            Patient patient1 = service.getPatientByName("Rkiya");
            System.out.println(patient1.getId());
            System.out.println(patient1.getNom());
            System.out.println(patient1.getDateNaissance());
            System.out.println(patient1.isMalade());
            System.out.println(patient1.getScore());

            System.out.println("***********************************");

            // supprimer patient

            try {
                service.supprimerPatientParNom("Hssayn");
                System.out.println("Le patient est supprimer avec succés !");
            }
            catch (Exception e) {
                e.getMessage();
            }

             */

        };
    }

}
