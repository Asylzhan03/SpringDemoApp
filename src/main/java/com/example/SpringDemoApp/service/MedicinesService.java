package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.Medicines;

import java.util.List;

public interface MedicinesService {
    Medicines addMedicines(Medicines medicines);
    List<Medicines> getAllMedicines();
    Medicines getMedicines(Long id);
    void deleteMedicines(Long id);
    Medicines updateMedicines(Long id, Medicines medicines);
    void deleteMedicinesAll();
}
