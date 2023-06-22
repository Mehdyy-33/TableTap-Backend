package manager.tabletap.productCount;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productCount")
public class ProductCountController {

    private final ProductCountService productCountService;


    @GetMapping("category/{id}/{categoryId}")
    public List<ProductCount> getByCategory(@PathVariable Integer id, @PathVariable("categoryId") Integer categoryId) {
        return productCountService.getByCategory(id, categoryId);
    }


}
