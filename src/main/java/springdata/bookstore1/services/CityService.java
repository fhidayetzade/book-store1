package springdata.bookstore1.services;

import springdata.bookstore1.dto.request.CityRequestDto;
import springdata.bookstore1.model.City;

import java.util.List;

public interface CityService {

    public void addCity(CityRequestDto cityRequestDto);
    public List<City> cities();
    public City getCityById (Integer cityId);
    public City editCity(CityRequestDto cityRequestDto, Integer cityId);
    public void deleteCity(Integer id);
}
