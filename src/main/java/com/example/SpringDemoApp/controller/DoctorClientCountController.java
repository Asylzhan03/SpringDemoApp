package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.DoctorClientCount;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.DoctorClientCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/doctorClientCount")
public class DoctorClientCountController {

    @Autowired
    private DoctorClientCountService doctorClientCountService;

    @GetMapping(value="/")
    public ResponseEntity<List<DoctorClientCount>> readDoctorClientCount() {
        List<DoctorClientCount> doctorClientCountList = doctorClientCountService.getAllDoctorClientCount();
        if(doctorClientCountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/addDoctorClientCount")
    public ResponseEntity<DoctorClientCount> addDoctorClientCount(@RequestBody DoctorClientCount doctorClientCount) {
        try {
            doctorClientCountService.addDoctorClientCount(doctorClientCount);
            return new ResponseEntity<>(doctorClientCount, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateDoctorClientCount")
    public ResponseEntity<HttpStatus> updateDoctorClientCount(@RequestParam Long id,
                                          @RequestBody DoctorClientCount doctorClientCount) {
        try {
            DoctorClientCount updatedDoctorClientCount = doctorClientCountService.updateDoctorClientCount(id, doctorClientCount);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteDoctorClientCount/{id}")
    public ResponseEntity<HttpStatus> deleteDoctorClientCount(@PathVariable("id") Long id) {
        try  {
            doctorClientCountService.deleteDoctorClientCount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteDoctorClientCount")
    public ResponseEntity<HttpStatus> deleteDoctorClientCount() {
        try {
            doctorClientCountService.deleteDoctorClientCountAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
