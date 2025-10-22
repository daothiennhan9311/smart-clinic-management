package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    // Create new appointment
    public String createAppointment(Appointment appointment) {
        appointments.add(appointment);
        return "Appointment created successfully!";
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int id) {
        return appointments.stream()
                .filter(a -> a.getAppointmentId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update appointment
    public String updateAppointment(int id, Appointment updatedAppointment) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == id) {
                appointment.setDate(updatedAppointment.getDate());
                appointment.setTime(updatedAppointment.getTime());
                appointment.setDoctorId(updatedAppointment.getDoctorId());
                appointment.setPatientId(updatedAppointment.getPatientId());
                appointment.setNotes(updatedAppointment.getNotes());
                return "Appointment updated successfully!";
            }
        }
        return "Appointment not found!";
    }

    // Delete appointment
    public String deleteAppointment(int id) {
        boolean removed = appointments.removeIf(a -> a.getAppointmentId() == id);
        return removed ? "Appointment deleted successfully!" : "Appointment not found!";
    }
}
