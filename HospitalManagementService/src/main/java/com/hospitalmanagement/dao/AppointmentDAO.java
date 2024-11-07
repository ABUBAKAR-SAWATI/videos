package com.hospitalmanagement.dao;

import com.hospitalmanagement.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private List<Appointment> appointments = new ArrayList<>();

    public void saveAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment saved: " + appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}


