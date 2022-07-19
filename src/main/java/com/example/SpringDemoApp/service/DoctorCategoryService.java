package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.DoctorCategory;

import java.util.List;

public interface DoctorCategoryService {
    DoctorCategory addDoctorCategory(DoctorCategory doctorCategory);
    List<DoctorCategory> getAllDoctorCategory();
    DoctorCategory getDoctorCategory(Long id);
    void deleteDoctorCategory(Long id);
    DoctorCategory updateDoctorCategory(Long id, DoctorCategory doctorCategory);
    void deleteDoctorCategoryAll();
}
