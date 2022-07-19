package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.DoctorCategory;
import com.example.SpringDemoApp.repository.DoctorCategoryRepository;
import com.example.SpringDemoApp.service.DoctorCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorCategoryServiceImplementation implements DoctorCategoryService {

    @Autowired
    private DoctorCategoryRepository doctorCategoryRepository;

    @Override
    public DoctorCategory addDoctorCategory(DoctorCategory doctorCategory) {
        return doctorCategoryRepository.save(doctorCategory);
    }

    @Override
    public List<DoctorCategory> getAllDoctorCategory() {
        return doctorCategoryRepository.findAll();
    }

    @Override
    public DoctorCategory getDoctorCategory(Long id) {
        return doctorCategoryRepository.getOne(id);
    }

    @Override
    public void deleteDoctorCategory(Long id) {

        doctorCategoryRepository.deleteById(id);
    }

    @Override
    public DoctorCategory updateDoctorCategory(Long id, DoctorCategory doctorCategory) {
        Optional<DoctorCategory> entity = doctorCategoryRepository.findById(id);
        if(entity.isPresent()) {
            DoctorCategory doctorCategory1 = entity.get();
            doctorCategory1.setId(doctorCategory.getId());
            doctorCategory1.setSalary(doctorCategory.getSalary());
            doctorCategory1.setDoctorPosition((doctorCategory.getDoctorPosition()));
            return doctorCategoryRepository.save(doctorCategory1);
        }
        return null;
    }

    @Override
    public void deleteDoctorCategoryAll() {
        doctorCategoryRepository.deleteAll();
    }
}
