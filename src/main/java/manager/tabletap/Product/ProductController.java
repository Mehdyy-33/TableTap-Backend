package manager.tabletap.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
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
    public Product update(@RequestBody Product product, @PathVariable Long id){
        return productService.update(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

}

