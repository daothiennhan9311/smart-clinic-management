package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private List<Prescription> prescriptions = new ArrayList<>();

    // GET all prescriptions
    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // GET prescription by ID
    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable int id) {
        return prescriptions.stream()
                .filter(p -> p.getPrescriptionId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST - Add new prescription
    @PostMapping
    public String addPrescription(@RequestBody Prescription prescription) {
        prescriptions.add(prescription);
        return "Prescription added successfully!";
    }

    // PUT - Update prescription
    @PutMapping("/{id}")
    public String updatePrescription(@PathVariable int id, @RequestBody Prescription updatedPrescription) {
        for (Prescription p : prescriptions) {
            if (p.getPrescriptionId() == id) {
                p.setDoctorId(updatedPrescription.getDoctorId());
                p.setPatientId(updatedPrescription.getPatientId());
                p.setMedicineName(updatedPrescription.getMedicineName());
                p.setDosage(updatedPrescription.getDosage());
                p.setInstructions(updatedPrescription.getInstructions());
                return "Prescription updated successfully!";
            }
        }
        return "Prescription not found!";
    }

    // DELETE - Remove prescription
    @DeleteMapping("/{id}")
    public String deletePrescription(@PathVariable int id) {
        boolean removed = prescriptions.removeIf(p -> p.getPrescriptionId() == id);
        return removed ? "Prescription deleted successfully!" : "Prescription not found!";
    }
}
