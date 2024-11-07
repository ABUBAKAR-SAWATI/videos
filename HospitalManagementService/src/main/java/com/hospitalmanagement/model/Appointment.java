package com.hospitalmanagement.model;

public class Appointment {
    private Doctor doctor;
    private String patientName;

    public Appointment(Doctor doctor, String patientName) {
        this.doctor = doctor;
        this.patientName = patientName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    public String toString() {
        return "Appointment with " + doctor.getName() + " for " + patientName;
    }
}



