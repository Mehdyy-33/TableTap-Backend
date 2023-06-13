package manager.tabletap.productCount;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCountService {

    private final ProductCountRepository testRepository;

    public List<ProductCount> getAll() {
        return testRepository.findAll();
    }


    public List<ProductCount> getByCategory(Integer categoryId) {
        return testRepository.getByCategory(categoryId);
    }
}
