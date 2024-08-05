package springdata.bookstore1.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.bookstore1.dto.request.CityRequestDto;
import springdata.bookstore1.model.City;
import springdata.bookstore1.services.CityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private final CityServiceImpl cityService;

    @PostMapping("/add")
    public void addCity(@RequestBody CityRequestDto cityRequestDto){
        cityService.addCity(cityRequestDto);
    }

    @GetMapping("/all")
    public List<City> cities(){
        return cityService.cities();
    }

    @GetMapping("/get/{id}")
    public City cityBydId(@PathVariable final Integer id){
        return cityService.getCityById(id);
    }

    @PostMapping("/update/{cityId}")
    public City editCity(@RequestBody CityRequestDto cityRequestDto, @PathVariable Integer cityId){
        return cityService.editCity(cityRequestDto,cityId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer id){
        try {
            cityService.deleteCity(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
