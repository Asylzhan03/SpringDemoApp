package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.City;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value="/")
    public ResponseEntity<List<City>> readCity() {
        List<City> cityList = cityService.getAllCity();
        if(cityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(cityList, HttpStatus.OK);
        }
    }

    @PostMapping(value="/addCity")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        try {
            cityService.addCity(city);
            return new ResponseEntity<>(city, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateCity")
    public ResponseEntity<HttpStatus> updateCity(@RequestParam Long id,
                             @RequestBody City city) {
        try {
            City updatedCity = cityService.updateCity(id, city);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteCity/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") Long id) {
        try  {
            cityService.deleteCity(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteCity")
    public ResponseEntity<HttpStatus> deleteCityAll() {
        try{
                cityService.deleteCityAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
