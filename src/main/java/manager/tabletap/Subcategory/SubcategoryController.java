package manager.tabletap.Subcategory;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subcategories")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping
    public List<Subcategory> getAll() {
        return subcategoryService.getAll();
    }

    @GetMapping("/{id}")
    public Subcategory getById(@PathVariable Long id) {
        return subcategoryService.getById(id);
    }

    @GetMapping("/category/{id}")
    public List<Subcategory> getByCategoryId(@PathVariable Long id) {
        return subcategoryService.getByCategoryId(id);
    }


    @PostMapping("/add")
    public Subcategory add(@RequestBody Subcategory subcategory) {
        return subcategoryService.add(subcategory);
    }

    @PutMapping("/update/{id}")
    public Subcategory update(@RequestBody Subcategory subcategory, @PathVariable Long id) {
        return subcategoryService.update(subcategory, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        subcategoryService.delete(id);
    }
}
