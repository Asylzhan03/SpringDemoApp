package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.DoctorCategory;
import com.example.SpringDemoApp.entity.DoctorClientCount;
import com.example.SpringDemoApp.repository.DoctorClientCountRepository;
import com.example.SpringDemoApp.service.DoctorClientCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorClientCountServiceImplementation implements DoctorClientCountService {

    @Autowired
    private DoctorClientCountRepository doctorClientCountRepository;

    @Override
    public DoctorClientCount addDoctorClientCount(DoctorClientCount doctorClientCount) {
        return doctorClientCountRepository.save(doctorClientCount);
    }

    @Override
    public List<DoctorClientCount> getAllDoctorClientCount() {
        return doctorClientCountRepository.findAll();
    }

    @Override
    public DoctorClientCount getDoctorClientCount(Long id) {
        return doctorClientCountRepository.getOne(id);
    }

    @Override
    public void deleteDoctorClientCount(Long id) {
        doctorClientCountRepository.deleteById(id);
    }

    @Override
    public DoctorClientCount updateDoctorClientCount(Long id, DoctorClientCount doctorClientCount) {
        Optional<DoctorClientCount> entity = doctorClientCountRepository.findById(id);
        if(entity.isPresent()) {
            DoctorClientCount doctorClientCount1 = entity.get();
            doctorClientCount1.setId(doctorClientCount.getId());
            doctorClientCount1.setCounter(doctorClientCount.getCounter());
            return doctorClientCountRepository.save(doctorClientCount1);
        }
        return null;
    }

    @Override
    public void deleteDoctorClientCountAll() {
        doctorClientCountRepository.deleteAll();
    }
}
