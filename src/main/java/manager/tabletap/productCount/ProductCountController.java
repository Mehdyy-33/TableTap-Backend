package manager.tabletap.productCount;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productCount")
public class ProductCountController {

    private final ProductCountService testService;

    @GetMapping
    public List<ProductCount> getAll() {
        return testService.getAll();
    }

    @GetMapping("category/{categoryId}")
    public List<ProductCount> getByCategory(@PathVariable("categoryId") Integer categoryId) {
        return testService.getByCategory(categoryId);
    }


}
