package springdata.bookstore1.services;

import springdata.bookstore1.dto.request.CategoryRequest;
import springdata.bookstore1.dto.response.CategoryResponse;

public interface CategoryService {

    public CategoryResponse addCategory (CategoryRequest categoryRequest);
}
