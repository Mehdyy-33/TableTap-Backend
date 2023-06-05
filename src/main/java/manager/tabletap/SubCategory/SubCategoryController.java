package manager.tabletap.SubCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subcategories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping
    public List<SubCategory> getAll(){
        return subCategoryService.getAll();
    }

    @GetMapping("/{id}")
    public SubCategory getById(@PathVariable Long id){
        return subCategoryService.getById(id);
    }

    @GetMapping("/category/{id}")
    public List<SubCategory> getByCategoryId(@PathVariable Long id){
        return subCategoryService.getByCategoryId(id);
    }


    @PostMapping("/add")
    public SubCategory add(@RequestBody SubCategory subCategory){
        return subCategoryService.add(subCategory);
    }

    @PutMapping("/update/{id}")
    public SubCategory update(@RequestBody SubCategory subCategory, @PathVariable Long id){
        return subCategoryService.update(subCategory, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        subCategoryService.delete(id);
    }
}
