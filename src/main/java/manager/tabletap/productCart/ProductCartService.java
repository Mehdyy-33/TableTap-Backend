package manager.tabletap.productCart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartService {

    private final ProductCartRepository productCartRepository;

    public List<ProductCart> getAllProductCart() {
        return productCartRepository.getAllProductCart();
    }

    public List<Integer> getAllTable() {
        return productCartRepository.findAllTable();
    }

    public ProductCart getById(Long id) {
        return productCartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductCart not found"));
    }

    public List<ProductCart> addProductCart(List<ProductCart> productCartList) {
        productCartList.forEach(productCart -> productCart.setTotal(productCart.getQuantity() * productCart.getPrice()));
        return productCartRepository.saveAll(productCartList);
    }

    public ProductCart help(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    public ProductCart updateProductCart(Long id, ProductCart productCart) {
        ProductCart foundProductCart = getById(id);
        foundProductCart.setViewStaff(productCart.isViewStaff());
        foundProductCart.setValid(!productCart.isValid());
        return productCartRepository.save(foundProductCart);
    }

    public void deleteProductCart(Long id) {
        if (productCartRepository.existsById(id)) {
            productCartRepository.deleteById(id);
        }
    }

    public List<ProductCart> getByNumberTable(Integer numberTable) {
        return productCartRepository.findByNumberTable(numberTable);
    }

    public Double getTotalByNumberTable(Integer numberTable) {
        return productCartRepository.getTotalByNumberTable(numberTable);
    }

}
