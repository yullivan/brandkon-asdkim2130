package brandkon.Category;

import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //카테고리 목록 조회
    @GetMapping("/categories")
    public List<CategoryResponse> getAllCategories(){  //List로 return
        return categoryService.listAllCategory();
    }


}
