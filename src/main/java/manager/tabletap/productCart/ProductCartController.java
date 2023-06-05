package manager.tabletap.productCart;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCart")
@RequiredArgsConstructor
public class ProductCartController {

    private final ProductCartService productCartService;

    @GetMapping
    public List<ProductCart> getAll() {
        return productCartService.getAllProductCart();
    }

    @GetMapping("/{id}")
    public ProductCart getById(@PathVariable("id") Long id) {
        return productCartService.getById(id);
    }

    @GetMapping("/allNumberTable")
    public List<Integer> getAllTable() {
        return productCartService.getAllTable();
    }

    @GetMapping("/getByNumberTable/{numberTable}")
    public List<ProductCart> getByNumberTable(@PathVariable("numberTable") Integer numberTable) {
        return productCartService.getByNumberTable(numberTable);
    }

    @GetMapping("/getTotalByNumberTable/{numberTable}")
    public Double getTotalByNumberTable(@PathVariable("numberTable") Integer numberTable) {
        return productCartService.getTotalByNumberTable(numberTable);
    }

    @PostMapping("/add")
    public List<ProductCart> addProductCart(@RequestBody List<ProductCart> productCart) {
        return productCartService.addProductCart(productCart);
    }

    @PostMapping("/help")
    public ProductCart help(@RequestBody ProductCart productCart) {
        return productCartService.help(productCart);
    }

    @PutMapping("/update/{id}")
    public ProductCart updateProductCart(@PathVariable Long id, @RequestBody ProductCart productCart) {
        return productCartService.updateProductCart(id, productCart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductCart(@PathVariable Long id) {
        productCartService.deleteProductCart(id);
    }
}
