package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private List<Doctor> doctorList = new ArrayList<>();

    // GET all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    // GET a doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorList.stream()
                .filter(d -> d.getDoctorId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST - add new doctor
    @PostMapping
    public String addDoctor(@RequestBody Doctor doctor) {
        doctorList.add(doctor);
        return "Doctor added successfully!";
    }

    // PUT - update doctor
    @PutMapping("/{id}")
    public String updateDoctor(@PathVariable int id, @RequestBody Doctor updatedDoctor) {
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId() == id) {
                doctor.setName(updatedDoctor.getName());
                doctor.setSpecialty(updatedDoctor.getSpecialty());
                doctor.setEmail(updatedDoctor.getEmail());
                doctor.setPhone(updatedDoctor.getPhone());
                return "Doctor updated successfully!";
            }
        }
        return "Doctor not found!";
    }

    // DELETE - remove doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {
        boolean removed = doctorList.removeIf(d -> d.getDoctorId() == id);
        return removed ? "Doctor deleted successfully!" : "Doctor not found!";
    }
}
