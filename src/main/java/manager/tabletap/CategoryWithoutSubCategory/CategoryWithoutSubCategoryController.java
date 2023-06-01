package manager.tabletap.CategoryWithoutSubCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories-without-subcategories")
public class CategoryWithoutSubCategoryController {

    private final CategoryWithoutSubCategoryService categoryWithoutSubCategoryService;

    @GetMapping
    public List<CategoryWithoutSubCategory> getAll(){
        return categoryWithoutSubCategoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryWithoutSubCategory getById(@PathVariable Long id){
        return categoryWithoutSubCategoryService.getById(id);
    }

    @PostMapping("/add")
    public CategoryWithoutSubCategory add(@RequestBody CategoryWithoutSubCategory categoryWithoutSubCategory){
        return categoryWithoutSubCategoryService.add(categoryWithoutSubCategory);
    }

    @PutMapping("/update/{id}")
    public CategoryWithoutSubCategory update(@RequestBody CategoryWithoutSubCategory categoryWithoutSubCategory, @PathVariable Long id){
        return categoryWithoutSubCategoryService.update(categoryWithoutSubCategory, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        categoryWithoutSubCategoryService.delete(id);
    }
}
