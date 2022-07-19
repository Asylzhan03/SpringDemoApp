package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.DoctorClientCount;

import java.util.List;

public interface DoctorClientCountService {
    DoctorClientCount addDoctorClientCount(DoctorClientCount doctorClientCount);
    List<DoctorClientCount> getAllDoctorClientCount();
    DoctorClientCount getDoctorClientCount(Long id);
    void deleteDoctorClientCount(Long id);
    DoctorClientCount updateDoctorClientCount(Long id, DoctorClientCount doctorClientCount);
    void deleteDoctorClientCountAll();
}
