package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.Staff;

import java.util.List;

public interface StaffService {
    Staff addStaff(Staff staff);
    List<Staff> getAllStaff();
    Staff getStaff(Long id);
    void deleteStaff(Long id);
    Staff updateStaff(Long id, Staff staff);
    void deleteStaffAll();
}
