package com.example.SpringDemoApp.repository;

import com.example.SpringDemoApp.entity.DoctorClientCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorClientCountRepository extends JpaRepository<DoctorClientCount, Long> {

}
