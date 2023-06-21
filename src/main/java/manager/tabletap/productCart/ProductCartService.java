package manager.tabletap.productCart;

import jakarta.transaction.Transactional;
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
        productCartList.forEach(productCart -> {
            productCart.setTotal(productCart.getQuantity() * productCart.getPrice());
            productCart.setViewStaff(true);
            productCart.setValid(false);
        });
        return productCartRepository.saveAll(productCartList);
    }

    public ProductCart help(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    public List<Integer> updateProductCart( List<Long> idList) {
            idList.forEach(id -> {
                ProductCart productCart = getById(id);
                productCart.setValid(true);
                productCartRepository.save(productCart);
            });
        return null;
    }


    public List<ProductCart> getByNumberTable(Integer numberTable) {
        return productCartRepository.findByNumberTable(numberTable);
    }

    public Double getTotalByNumberTable(Integer numberTable) {
        return productCartRepository.getTotalByNumberTable(numberTable);
    }

    @Transactional
    public void deleteProductCart(Integer numberTable) {
        productCartRepository.deleteByNumberTable(numberTable);
    }

    public void deleteProductCartById(Long id) {
        productCartRepository.deleteById(id);
    }


    public List<Object> getProductCartByMoment() {
        return productCartRepository.getProductCartByMoment();
    }
}
