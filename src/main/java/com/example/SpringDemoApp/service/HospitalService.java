package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.Hospital;

import java.util.List;

public interface HospitalService {
    Hospital addHospital(Hospital hospital);
    List<Hospital> getAllHospital();
    Hospital getHospital(Long id);
    void deleteHospital(Long id);
    Hospital updateHospital(Long id, Hospital hospital);
    void deleteHospitalAll();
}
