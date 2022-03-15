package by.asalalaiko.service.impl;

import by.asalalaiko.domain.City;
import by.asalalaiko.repo.CityRepo;
import by.asalalaiko.repo.UserRepo;
import by.asalalaiko.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPACityService implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Override
    public City getCityById(Long id) {
        return cityRepo.getOne(id);
    }

    @Override
    public List<City> getCities() {
        return cityRepo.findAll();
    }

    @Override
    public void createCity(City city) {
        cityRepo.save(city);
    }

    @Override
    public void updateCity(City city) {
        cityRepo.save(city);

    }

    @Override
    public void deleteById(Long id) {
        cityRepo.deleteById(id);
    }
}
