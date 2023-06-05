package manager.tabletap.SubCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAll(){
        return subCategoryRepository.findAll();
    };

    public SubCategory getById(Long id){
        return subCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public SubCategory add(SubCategory subCategory){
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory update(SubCategory subCategory, Long id){
        SubCategory found = getById(id);
        found.setLabel(subCategory.getLabel());
        found.setImg(subCategory.getImg());

        return subCategoryRepository.save(found);
    }

    public void delete(Long id){
        subCategoryRepository.deleteById(id);
    }
}
