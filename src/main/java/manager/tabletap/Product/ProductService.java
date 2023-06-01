package manager.tabletap.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    };

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Product add(Product product){
        return productRepository.save(product);
    }

    public Product update(Product product, Long id){
        Product found = getById(id);
        found.setTitle(product.getTitle());
        found.setDescription(product.getDescription());
        found.setImg(product.getImg());
        found.setPrice(product.getPrice());
        found.setCategory(product.getCategory());
        found.setSubCategory(product.getSubCategory());
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
