package com.hospitalmanagement.gui;

import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.service.AppointmentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystemGUI {
    private static AppointmentService appointmentService;

    public static void main(String[] args) {
        appointmentService = new AppointmentService();
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. Smith"));
        doctors.add(new Doctor("Dr. Johnson"));
        
        JFrame frame = new JFrame("Hospital Management System - Book Appointment");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel instructionLabel = new JLabel("Select Doctor:");
        JComboBox<Doctor> doctorComboBox = new JComboBox<>();
        for (Doctor doctor : doctors) {
            doctorComboBox.addItem(doctor);
        }

        JTextField patientNameField = new JTextField();
        JButton bookButton = new JButton("Book Appointment");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor selectedDoctor = (Doctor) doctorComboBox.getSelectedItem();
                String patientName = patientNameField.getText();
                
                try {
                    appointmentService.bookAppointment(selectedDoctor, patientName);
                    outputArea.setText("Appointment booked successfully for " + patientName + " with " + selectedDoctor.getName());
                } catch (Exception ex) {
                    outputArea.setText("Error booking appointment. Please try again.");
                }
            }
        });

        frame.add(instructionLabel);
        frame.add(doctorComboBox);
        frame.add(new JLabel("Enter Patient Name:"));
        frame.add(patientNameField);
        frame.add(bookButton);
        frame.add(outputArea);
        frame.setVisible(true);
    }
}
