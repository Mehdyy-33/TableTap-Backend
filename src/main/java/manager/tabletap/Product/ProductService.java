package manager.tabletap.Product;

import lombok.RequiredArgsConstructor;
import manager.tabletap.Category.Category;
import manager.tabletap.Category.CategoryService;
import manager.tabletap.Subcategory.Subcategory;
import manager.tabletap.Subcategory.SubcategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    public List<Product> getAll(){
        return productRepository.findAll();
    };

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Product add(Product product){
        Long categoryId = product.getCategory().getId();
        Category category = categoryService.getById(categoryId);
        product.setCategory(category);

        Long subcategoryId = product.getSubcategory().getId();
        Subcategory subcategory = subcategoryService.getById(subcategoryId);

        if (!subcategory.getCategory().getId().equals(categoryId)) {
            throw new RuntimeException("La sous-catégorie ne correspond pas à la catégorie associée.");
        }

        product.setSubcategory(subcategory);

        return productRepository.save(product);
    }

    public Product update(Product product, Long id){
        Product found = getById(id);
        found.setTitle(product.getTitle());
        found.setDescription(product.getDescription());
        found.setImg(product.getImg());
        found.setPrice(product.getPrice());
        found.setCategory(product.getCategory());
        found.setSubcategory(product.getSubcategory());
        found.setSpicyLvl(product.getSpicyLvl());
        found.setIsVege(product.getIsVege());
        found.setIsGlutenFree(product.getIsGlutenFree());
        found.setIsAvailable(product.getIsAvailable());

        return productRepository.save(found);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
