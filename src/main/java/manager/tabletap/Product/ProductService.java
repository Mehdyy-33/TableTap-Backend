package manager.tabletap.Product;

import lombok.RequiredArgsConstructor;
import manager.tabletap.Category.Category;
import manager.tabletap.Category.CategoryService;
import manager.tabletap.Subcategory.Subcategory;
import manager.tabletap.Subcategory.SubcategoryService;
import manager.tabletap.user.User;
import manager.tabletap.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    private final UserService userService;

    public List<Product> getAll(Long id){
        return productRepository.findAllByUserId(id);
    }

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

        Long userId = product.getUser().getId();
        User user = userService.getById(userId);
        product.setUser(user);

        if (!subcategory.getCategory().getId().equals(categoryId)) {
            throw new RuntimeException("La sous-catégorie ne correspond pas à la catégorie associée.");
        }

        if(!product.getUser().getId().equals(userId)) {
            throw new RuntimeException("Le produit ne correspond pas à l'utilisateur associé.");

        }

        product.setSubcategory(subcategory);

        return productRepository.save(product);
    }

    public Product update(Long id, Product product){
        Product found = getById(id);
        found.setTitle(product.getTitle());
        found.setDescription(product.getDescription());
        found.setImg(product.getImg());
        found.setPrice(product.getPrice());
        found.setSpicyLvl(product.getSpicyLvl());
        found.setIsVege(product.getIsVege());
        found.setIsGlutenFree(product.getIsGlutenFree());

        return productRepository.save(found);
    }

    public Product updateAvailability(Long id, Product product){
        Product found = getById(id);
        found.setIsAvailable(product.getIsAvailable());

        return productRepository.save(found);
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }


}
