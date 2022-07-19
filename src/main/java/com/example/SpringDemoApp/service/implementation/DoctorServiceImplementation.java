package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.Doctor;
import com.example.SpringDemoApp.repository.DoctorRepository;
import com.example.SpringDemoApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImplementation implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Optional<Doctor> entity = doctorRepository.findById(id);
        if(entity.isPresent()) {
            Doctor doctor1 = entity.get();
            doctor1.setId(doctor.getId());
            doctor1.setName((doctor.getName()));
            doctor1.setSurname(doctor.getSurname());
            return doctorRepository.save(doctor1);
        }
        return null;
    }

    @Override
    public void deleteDoctorAll() {
        doctorRepository.deleteAll();
    }
}
