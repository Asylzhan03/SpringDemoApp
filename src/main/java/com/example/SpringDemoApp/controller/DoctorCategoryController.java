package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.DoctorCategory;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.DoctorCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/doctorCategory")
public class DoctorCategoryController {

    @Autowired
    private DoctorCategoryService doctorCategoryService;

    @GetMapping(value="/")
    public ResponseEntity<List<DoctorCategory>> readDoctorCategory() {
        List<DoctorCategory> doctorCategoryList = doctorCategoryService.getAllDoctorCategory();
        if(doctorCategoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/addDoctorCategory")
    public ResponseEntity<DoctorCategory> addDoctorCategory(@RequestBody DoctorCategory doctorCategory) {
        try {
            doctorCategoryService.addDoctorCategory(doctorCategory);
            return new ResponseEntity<>(doctorCategory, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateDoctorCategory")
    public ResponseEntity<HttpStatus> updateDoctorCategory(@RequestParam Long id,
                                       @RequestBody DoctorCategory doctorCategory) {
        try {
            DoctorCategory updatedDoctorCategory = doctorCategoryService.updateDoctorCategory(id, doctorCategory);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteDoctorCategory/{id}")
    public ResponseEntity<HttpStatus> deleteDoctorCategory(@PathVariable("id") Long id) {
        try  {
            doctorCategoryService.deleteDoctorCategory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteDoctorCategory")
    public ResponseEntity<HttpStatus> deleteDoctorCategoryAll() {
        try {
            doctorCategoryService.deleteDoctorCategoryAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
