package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.Hospital;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value="/")
    public ResponseEntity<List<Hospital>> readHospital() {
        List<Hospital> hospitalList = hospitalService.getAllHospital();
        if(hospitalList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/addHospital")
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
        try {
            hospitalService.addHospital(hospital);
            return new ResponseEntity<>(hospital, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateHospital")
    public ResponseEntity<HttpStatus> updateHospital(@RequestParam Long id,
                                 @RequestBody Hospital hospital) {
        try {
            Hospital updatedHospital = hospitalService.updateHospital(id, hospital);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteHospital/{id}")
    public ResponseEntity<HttpStatus> deleteHospital(@PathVariable("id") Long id) {
        try  {
            hospitalService.deleteHospital(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteHospital")
    public ResponseEntity<HttpStatus> deleteHospitalAll() {
        try {
            hospitalService.deleteHospitalAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
