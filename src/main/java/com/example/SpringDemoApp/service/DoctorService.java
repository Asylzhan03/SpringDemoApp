package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> getAllDoctor();
    Doctor getDoctor(Long id);
    void deleteDoctor(Long id);
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteDoctorAll();

}
