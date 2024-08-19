package springdata.bookstore1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.bookstore1.dto.request.CityRequestDto;
import springdata.bookstore1.model.City;
import springdata.bookstore1.repositories.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;
    @Override
    public void addCity(CityRequestDto cityRequestDto) {
        City city = City.builder()
                .name(cityRequestDto.getName())
                .build();
        cityRepository.save(city);
    }

    @Override
    public List<City> cities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer cityId) {
         return cityRepository.findById(cityId).
                 orElseThrow(()-> new IllegalArgumentException("city with cityId "+ cityId+ " could not be found"));
    }

    @Override
    public City editCity(CityRequestDto cityRequestDto, Integer cityId) {
            Optional<City> cityOptional = cityRepository.findById(cityId);
            if(cityOptional.isPresent()){
                City city = cityOptional.get();
                city.setName(cityRequestDto.getName());
               return cityRepository.save(city);
            }else {
                throw new RuntimeException("City not found id "+cityId);
            }


    }

    @Override
    public void deleteCity(Integer id) {
       if(cityRepository.existsById(id)){
           cityRepository.deleteById(id);
       } else {
           throw new RuntimeException("City not found by id "+id);
       }
    }
}
