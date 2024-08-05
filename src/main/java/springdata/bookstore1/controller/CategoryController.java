package springdata.bookstore1.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdata.bookstore1.dto.request.CategoryRequest;
import springdata.bookstore1.dto.response.CategoryResponse;
import springdata.bookstore1.services.CategoryService;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/addCategory")
    public CategoryResponse categoryResponse (@RequestBody CategoryRequest categoryRequest){
        return categoryService.addCategory(categoryRequest);
    }


}
