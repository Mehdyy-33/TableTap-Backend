package manager.tabletap.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/user/{id}")
    public List<Product> getAll(@PathVariable Long id){
        return productService.getAll(id);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @PutMapping("/updateAvailability/{id}")
    public Product updateAvailability(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateAvailability(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

}

