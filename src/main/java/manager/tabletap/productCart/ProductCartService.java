package manager.tabletap.productCart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartService {

    private final ProductCartRepository productCartRepository;

    public List<ProductCart> getAll() {
        return productCartRepository.findAll();
    }


    public List<ProductCart> addProductCart(List<ProductCart> productCart) {
        return productCartRepository.saveAll(productCart);
    }

    public ProductCart help(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }
}
