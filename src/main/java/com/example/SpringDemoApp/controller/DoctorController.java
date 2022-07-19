package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.Doctor;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value="/")
    public ResponseEntity<List<Doctor>> readDoctor() {
        List<Doctor> doctorList = doctorService.getAllDoctor();
        if(doctorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        try {
            doctorService.addDoctor(doctor);
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateDoctor")
    public ResponseEntity<HttpStatus> updateDoctor(@RequestParam Long id,
                               @RequestBody Doctor doctor) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteDoctor/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") Long id) {
        try  {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteDoctor")
    public ResponseEntity<HttpStatus> deleteDoctorAll() {
        try {
            doctorService.deleteDoctorAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
