package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.Doctor;
import com.example.SpringDemoApp.entity.Medicines;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.MedicinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/medicines")
public class MedicinesController {

    @Autowired
    private MedicinesService medicinesService;

    @GetMapping(value="/")
    public ResponseEntity<List<Medicines>> readMedicines() {
        List<Medicines> medicinesList = medicinesService.getAllMedicines();
        if(medicinesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/addMedicines")
    public ResponseEntity<Medicines> addMedicines(@RequestBody Medicines medicines) {
        try {
            medicinesService.addMedicines(medicines);
            return new ResponseEntity<>(medicines, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateMedicines")
    public ResponseEntity<HttpStatus> updateMedicines(@RequestParam Long id,
                                  @RequestBody Medicines medicines) {
        try {
            Medicines updatedMedicines = medicinesService.updateMedicines(id, medicines);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteMedicines/{id}")
    public ResponseEntity<HttpStatus> deleteMedicines(@PathVariable("id") Long id) {
        try  {
            medicinesService.deleteMedicines(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteMedicines")
    public ResponseEntity<HttpStatus> deleteMedicines() {
        try {
            medicinesService.deleteMedicinesAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
