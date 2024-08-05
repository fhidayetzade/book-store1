package springdata.bookstore1.dto.mapper;

import springdata.bookstore1.dto.response.CategoryResponse;
import springdata.bookstore1.model.Book;
import springdata.bookstore1.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MapperDto {

    public static CategoryResponse categoryToCategoryResponse(Category category){
        CategoryResponse categoryResp = CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        List<String> names = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        for (Book book : books){
            names.add(book.getName());
        }
        categoryResp.setBookNames(names);
        return categoryResp;
    }
}
