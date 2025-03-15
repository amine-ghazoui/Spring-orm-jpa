package org.example.springjpa.Controller;

import org.example.springjpa.entities.Patient;
import org.example.springjpa.service.IHospitalServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    private IHospitalServiceImpl hospitalServiceImpl;

    @GetMapping("/patients")
    public List<Patient> patientList(){
        return hospitalServiceImpl.afficherPatients();
    }
}
