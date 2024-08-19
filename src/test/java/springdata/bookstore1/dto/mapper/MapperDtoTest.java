package springdata.bookstore1.dto.mapper;

import org.junit.jupiter.api.Test;
import springdata.bookstore1.dto.response.CategoryResponse;
import springdata.bookstore1.model.Category;

import static org.junit.jupiter.api.Assertions.*;

class MapperDtoTest {

    @Test
    void toEntityTest(){
        var request = new Category();
        request.setName("Name");


    }

}