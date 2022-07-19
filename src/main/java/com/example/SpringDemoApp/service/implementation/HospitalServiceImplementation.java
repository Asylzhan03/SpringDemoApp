package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.Hospital;
import com.example.SpringDemoApp.repository.HospitalRepository;
import com.example.SpringDemoApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImplementation implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospital(Long id) {
        return hospitalRepository.getOne(id);
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public Hospital updateHospital(Long id, Hospital hospital) {
        Optional<Hospital> entity = hospitalRepository.findById(id);
        if(entity.isPresent()) {
            Hospital hospital1 = entity.get();
            hospital1.setId(hospital.getId());
            hospital1.setName(hospital.getName());
            hospital1.setAddress(hospital.getAddress());
            return hospitalRepository.save(hospital1);
        }
        return null;
    }

    @Override
    public void deleteHospitalAll() {
        hospitalRepository.deleteAll();
    }
}
