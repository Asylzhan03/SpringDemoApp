package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.controller.MedicinesController;
import com.example.SpringDemoApp.entity.Medicines;
import com.example.SpringDemoApp.repository.MedicinesRepository;
import com.example.SpringDemoApp.service.MedicinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicinesServiceImplementation implements MedicinesService {

    @Autowired
    private MedicinesRepository medicinesRepository;

    @Override
    public Medicines addMedicines(Medicines medicines) {
        return medicinesRepository.save(medicines);
    }

    @Override
    public List<Medicines> getAllMedicines() {
        return medicinesRepository.findAll();
    }

    @Override
    public Medicines getMedicines(Long id) {
        return medicinesRepository.getOne(id);
    }

    @Override
    public void deleteMedicines(Long id) {
        medicinesRepository.deleteById(id);
    }

    @Override
    public Medicines updateMedicines(Long id, Medicines medicines) {
        Optional<Medicines> entity = medicinesRepository.findById(id);
        if(entity.isPresent()) {
            Medicines medicines1 = entity.get();
            medicines1.setId(medicines.getId());
            medicines1.setName(medicines.getName());
            medicines1.setPrice(medicines.getPrice());
            medicines1.setAmount(medicines.getAmount());
            return medicinesRepository.save(medicines1);
        }
        return null;
    }

    @Override
    public void deleteMedicinesAll() {
        medicinesRepository.deleteAll();
    }
}
