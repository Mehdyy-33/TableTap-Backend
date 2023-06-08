package manager.tabletap.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    };

    public Category getById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Category add(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Category category, Long id){
        Category found = getById(id);
        found.setLabel(category.getLabel());
        category.setSubcategories(category.getSubcategories());
        return categoryRepository.save(found);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}
