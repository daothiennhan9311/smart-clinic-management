package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final List<Doctor> doctors = new ArrayList<>();

    // Create doctor
    public String addDoctor(Doctor doctor) {
        doctors.add(doctor);
        return "Doctor added successfully!";
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Get doctor by ID
    public Doctor getDoctorById(int id) {
        return doctors.stream()
                .filter(d -> d.getDoctorId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update doctor
    public String updateDoctor(int id, Doctor updatedDoctor) {
        for (Doctor doctor : doctors) {
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

    // Delete doctor
    public String deleteDoctor(int id) {
        boolean removed = doctors.removeIf(d -> d.getDoctorId() == id);
        return removed ? "Doctor deleted successfully!" : "Doctor not found!";
    }
}
