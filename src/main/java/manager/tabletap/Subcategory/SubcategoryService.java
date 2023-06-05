package manager.tabletap.Subcategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public List<Subcategory> getAll(){
        return subcategoryRepository.findAll();
    }

    public Subcategory getById(Long id){
        return subcategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Subcategory add(Subcategory subcategory){
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory update(Subcategory subCategory, Long id){
        Subcategory found = getById(id);
        found.setLabel(subCategory.getLabel());
        found.setImg(subCategory.getImg());

        return subcategoryRepository.save(found);
    }

    public void delete(Long id){
        subcategoryRepository.deleteById(id);
    }

    public List<Subcategory> getByCategoryId(Long id) {
        return subcategoryRepository.findByCategoryId(id);
    }
}
