package manager.tabletap.productCart;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import manager.tabletap.user.User;
import manager.tabletap.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartService {

    private final ProductCartRepository productCartRepository;
    private final UserService userService;

    public List<ProductCart> getAllProductCart(Long id) {
        return productCartRepository.getAllProductCart(id);
    }

    public List<Integer> getAllTable(Long id) {
        return productCartRepository.findAllTable(id);
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
            Long userId = productCart.getUser().getId();
            User user = userService.getById(userId);
            productCart.setUser(user);
        });
        return productCartRepository.saveAll(productCartList);
    }

    public ProductCart help(ProductCart productCart) {
        Long userId = productCart.getUser().getId();
        User user = userService.getById(userId);
        productCart.setUser(user);
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


    public List<ProductCart> getByNumberTable(Integer numberTable, Long id) {
        return productCartRepository.findByNumberTable(numberTable, id);
    }

    public Double getTotalByNumberTable(Integer numberTable, Long id) {
        return productCartRepository.getTotalByNumberTable(numberTable, id);
    }

    @Transactional
    public void deleteProductCart(Integer numberTable) {
        productCartRepository.deleteByNumberTable(numberTable);
    }

    public void deleteProductCartById(Long id) {
        productCartRepository.deleteById(id);
    }


}
