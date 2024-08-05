package springdata.bookstore1.services;

import springdata.bookstore1.dto.request.ZipcodeRequestDto;
import springdata.bookstore1.model.Zipcode;

import java.util.List;


public interface ZipcodeService {

    public Zipcode addZipcode (ZipcodeRequestDto zipcodeRequestDto);
    public List<Zipcode> getZipcodes();
    public Zipcode getZipcodeById (Integer id);
    public Zipcode editZipcode(Integer zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
    public Zipcode addCityToZipcode (Integer zipcodeId, Integer cityId);
    public Zipcode removeCityFromZipcode(Integer zipcodeId);
}
