package springdata.bookstore1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.bookstore1.dto.mapper.MapperDto;
import springdata.bookstore1.dto.request.CategoryRequest;
import springdata.bookstore1.dto.response.CategoryResponse;
import springdata.bookstore1.model.Category;
import springdata.bookstore1.repositories.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .build();
        categoryRepository.save(category);
        return MapperDto.categoryToCategoryResponse(category);
    }
}
