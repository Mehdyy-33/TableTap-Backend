package manager.tabletap.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category){
        return categoryService.add(category);
    }

    @PutMapping("/update/{id}")
    public Category update(@RequestBody Category category, @PathVariable Long id){
        return categoryService.update(category, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}