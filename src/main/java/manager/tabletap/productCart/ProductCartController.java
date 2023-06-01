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
        return productCartService.getAll();
    }

    @PostMapping("/add")
    public List<ProductCart> addProductCart(@RequestBody List<ProductCart> productCart) {
        return productCartService.addProductCart(productCart);
    }

    @PostMapping("/help")
    public ProductCart help(@RequestBody ProductCart productCart) {
        return productCartService.help(productCart);
    }

}
