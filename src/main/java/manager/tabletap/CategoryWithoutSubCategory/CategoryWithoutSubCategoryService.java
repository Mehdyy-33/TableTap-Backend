package manager.tabletap.CategoryWithoutSubCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryWithoutSubCategoryService {

    private CategoryWithoutSubCategoryRepository categoryWithoutSubCategoryRepository;

    public List<CategoryWithoutSubCategory> getAll(){
        return categoryWithoutSubCategoryRepository.findAll();
    };

    public CategoryWithoutSubCategory getById(Long id){
        return categoryWithoutSubCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public CategoryWithoutSubCategory add(CategoryWithoutSubCategory categoryWithoutSubCategory){
        return categoryWithoutSubCategoryRepository.save(categoryWithoutSubCategory);
    }

    public CategoryWithoutSubCategory update(CategoryWithoutSubCategory categoryWithoutSubCategory, Long id){
        CategoryWithoutSubCategory found = getById(id);
        found.setLabel(categoryWithoutSubCategory.getLabel());

        return categoryWithoutSubCategoryRepository.save(found);
    }

    public void delete(Long id){
        categoryWithoutSubCategoryRepository.deleteById(id);
    }
}

