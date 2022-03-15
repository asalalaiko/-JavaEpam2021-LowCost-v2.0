package by.asalalaiko.service;

import by.asalalaiko.domain.City;

import javax.mail.MessagingException;
import java.util.List;

public interface CityService {

    City getCityById (Long id);

    List<City> getCities();

    void createCity(City city);

    void updateCity(City city);

    public void deleteById (Long id);


}
