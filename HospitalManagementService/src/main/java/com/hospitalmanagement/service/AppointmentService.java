package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.dao.AppointmentDAO;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentService() {
        this.appointmentDAO = new AppointmentDAO();
    }

    

    public void bookAppointment(Doctor doctor, String patientName) {
        Appointment appointment = new Appointment(doctor, patientName);
        appointmentDAO.saveAppointment(appointment);
    }
}
