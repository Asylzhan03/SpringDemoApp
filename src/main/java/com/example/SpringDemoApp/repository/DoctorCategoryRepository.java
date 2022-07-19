package com.example.SpringDemoApp.repository;

import com.example.SpringDemoApp.entity.DoctorCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory, Long> {

}
