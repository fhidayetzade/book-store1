package springdata.bookstore1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdata.bookstore1.dto.request.ZipcodeRequestDto;
import springdata.bookstore1.model.City;
import springdata.bookstore1.model.Zipcode;
import springdata.bookstore1.repositories.CityRepository;
import springdata.bookstore1.repositories.ZipcodeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ZipcodeServiceImpl implements ZipcodeService{

    private final ZipcodeRepository zipcodeRepository;
    private final CityRepository cityRepository;
    private final CityService cityService;

    @Override
    public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcode = Zipcode.builder()
                .name(zipcodeRequestDto.getName())
                .build();
        if(zipcodeRequestDto.getCityId()==null){
          return   zipcodeRepository.save(zipcode);
        }
        Optional<City> cityOptional = cityRepository.findById(zipcodeRequestDto.getCityId());
        if(cityOptional.isPresent()){
            City city = cityOptional.get();
            zipcode.setCity(city);
            return zipcodeRepository.save(zipcode);
        }else
            throw new RuntimeException("exception");


    }

    @Override
    public List<Zipcode> getZipcodes() {
        return zipcodeRepository.findAll();
    }

    @Override
    public Zipcode getZipcodeById(Integer id) {
        return zipcodeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Zipcode not be found id "+id));
    }

    @Transactional
    @Override
    public Zipcode editZipcode(Integer zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToEdit = getZipcodeById(zipcodeId);
        zipcodeToEdit.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() == null) {
            return zipcodeToEdit;
        }
        City city = cityService.getCityById(zipcodeRequestDto.getCityId());
        zipcodeToEdit.setCity(city);
        return zipcodeToEdit;
    }

    @Transactional
    @Override
    public Zipcode addCityToZipcode(Integer zipcodeId, Integer cityId) {
        Zipcode zipcode = getZipcodeById(zipcodeId);
        City city = cityService.getCityById(cityId);
        if (Objects.nonNull(zipcode.getCity())){
            throw new IllegalArgumentException("zipcode already has a city");
        }
        zipcode.setCity(city);
        return zipcode;
    }

    @Transactional
    @Override
    public Zipcode removeCityFromZipcode(Integer zipcodeId) {
        Zipcode zipcode = getZipcodeById(zipcodeId);
        if (!Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zipcode does not have a city");
        }
        zipcode.setCity(null);
        return zipcode;
    }


}
