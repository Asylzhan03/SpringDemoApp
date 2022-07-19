package com.example.SpringDemoApp.repository;

import com.example.SpringDemoApp.entity.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicines, Long> {

}
