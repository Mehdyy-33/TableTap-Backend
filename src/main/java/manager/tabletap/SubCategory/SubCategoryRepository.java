package manager.tabletap.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    @Query(value= "SELECT * FROM sub_category WHERE category_id = ?", nativeQuery = true)
    List<SubCategory> findByCategoryId(Long id);
}
