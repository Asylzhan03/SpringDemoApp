package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.repository.StaffRepository;
import com.example.SpringDemoApp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImplementation implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaff(Long id) {
        return staffRepository.getOne(id);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        Optional<Staff> entity = staffRepository.findById(id);
        if(entity.isPresent()) {
            Staff staff1 = entity.get();
            staff1.setId(staff.getId());
            staff1.setName(staff.getName());
            staff1.setSurname(staff.getSurname());
            staff1.setGender(staff.getGender());
            staff1.setStaffPosition(staff.getStaffPosition());
            return staffRepository.save(staff1);
        }
        return null;
    }

    @Override
    public void deleteStaffAll() {
        staffRepository.deleteAll();
    }
}
