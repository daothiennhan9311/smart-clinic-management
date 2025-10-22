package com.project.back_end.models;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialty;
    private String email;
    private String phone;

    // Constructors
    public Doctor() {}

    public Doctor(int doctorId, String name, String specialty, String email, String phone) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
