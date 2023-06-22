package manager.tabletap.productCart;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCart")
@RequiredArgsConstructor
public class ProductCartController {

    private final ProductCartService productCartService;

    @GetMapping("user/{id}")
    public List<ProductCart> getAll(@PathVariable Long id) {
        return productCartService.getAllProductCart(id);
    }

    @GetMapping("/{id}")
    public ProductCart getById(@PathVariable Long id) {
        return productCartService.getById(id);
    }

    @GetMapping("/allNumberTable/user/{id}")
    public List<Integer> getAllTable(@PathVariable Long id) {
        return productCartService.getAllTable(id);
    }

    @GetMapping("/getByNumberTable/{numberTable}/user/{id}")
    public List<ProductCart> getByNumberTable(@PathVariable("numberTable") Integer numberTable, @PathVariable Long id) {
        return productCartService.getByNumberTable(numberTable, id);
    }

    @GetMapping("/getTotalByNumberTable/{numberTable}/user/{id}")
    public Double getTotalByNumberTable(@PathVariable("numberTable") Integer numberTable, @PathVariable Long id) {
        return productCartService.getTotalByNumberTable(numberTable, id);
    }

    @PostMapping("/add")
    public List<ProductCart> addProductCart(@RequestBody List<ProductCart> productCart) {
        return productCartService.addProductCart(productCart);
    }

    @PostMapping("/help")
    public ProductCart help(@RequestBody ProductCart productCart) {
        return productCartService.help(productCart);
    }

    @PutMapping("/update")
    public List<Integer> updateProductCart(@RequestBody List<Long> idList) {
        return productCartService.updateProductCart(idList);
    }

    @DeleteMapping("/deleteAllByNumberTable/{numberTable}")
    public void deleteProductCart(@PathVariable("numberTable") Integer numberTable) {
        productCartService.deleteProductCart(numberTable);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductCartById(@PathVariable("id") Long id) {
        productCartService.deleteProductCartById(id);
    }


}
