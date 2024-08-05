package springdata.bookstore1.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.bookstore1.dto.request.ZipcodeRequestDto;
import springdata.bookstore1.model.Zipcode;
import springdata.bookstore1.services.ZipcodeService;

import java.util.List;

@RestController
@RequestMapping("/zipcode")
@AllArgsConstructor
public class ZipcodeController {

    private final ZipcodeService zipcodeService;
    @PostMapping("/add")
    public Zipcode zipcode(@RequestBody ZipcodeRequestDto zipcodeRequestDto){
        return zipcodeService.addZipcode(zipcodeRequestDto);
    }

    @GetMapping("/all")
    public List<Zipcode> zipcodes(){
        return zipcodeService.getZipcodes();
    }


    @GetMapping("/get/{id}")
    public Zipcode zipcodeById(@PathVariable Integer id){
        return zipcodeService.getZipcodeById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Zipcode> editZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto,
                                               @PathVariable final Integer id) {
        Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/addZipcode/{zipcodeId}/addCity/{cityId}")
    public Zipcode addZipcodeToCity(@PathVariable Integer zipcodeId,
                                    @PathVariable Integer cityId){
        return zipcodeService.addCityToZipcode(zipcodeId,cityId);
    }
    @PostMapping("/deleteCity/{zipcodeId}")
    public ResponseEntity<Zipcode> deleteCity(@PathVariable final Integer zipcodeId) {
        Zipcode zipcode = zipcodeService.removeCityFromZipcode(zipcodeId);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

}
