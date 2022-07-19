package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.City;
import com.example.SpringDemoApp.repository.CityRepository;
import com.example.SpringDemoApp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImplementation implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City updateCity(Long id, City city) {
        Optional<City> entity = cityRepository.findById(id);
            if(entity.isPresent()){
                City city1 = entity.get();
                city1.setName(city.getName());
                return cityRepository.save(city1);
            }
            return null;
    }

    @Override
    public void deleteCityAll() {
        cityRepository.deleteAll();
    }
}