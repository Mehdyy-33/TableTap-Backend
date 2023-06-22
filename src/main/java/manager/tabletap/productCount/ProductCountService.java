package manager.tabletap.productCount;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCountService {

    private final ProductCountRepository productCountRepository;



    public List<ProductCount> getByCategory(Integer id, Integer categoryId) {
        return productCountRepository.getByCategory(id, categoryId);
    }
}
