package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.City;

import java.util.List;

public interface CityService {
    City addCity(City city);
    List<City> getAllCity();
    City getCity(Long id);
    void deleteCity(Long id);
    City updateCity(Long id, City city);
    void deleteCityAll();
}
