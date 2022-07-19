package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping(value="/")
    public ResponseEntity<List<Staff>> readStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        if(staffList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/addStaff")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        try {
            staffService.addStaff(staff);
            return new ResponseEntity<>(staff, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateStaff")
    public ResponseEntity<HttpStatus> updateStaff(@RequestParam Long id,
                              @RequestBody Staff staff) {
        try {
            Staff updatedStaff = staffService.updateStaff(id, staff);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteStaff/{id}")
    public ResponseEntity<HttpStatus> deleteStaff(@PathVariable("id") Long id) {
        try  {
            staffService.deleteStaff(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteStaff")
    public ResponseEntity<HttpStatus> deleteStaffAll() {
        try {
            staffService.deleteStaffAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
