package brandkon.Category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryResponse> listAllCategory(){
        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryResponse
                                (category.getId(),
                                category.getName(),
                                category.getSlug(),
                                category.getImageUrl()))
                .toList();

    }

}
