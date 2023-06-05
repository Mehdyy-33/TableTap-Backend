package manager.tabletap.Subcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    @Query(value= "SELECT * FROM sub_category WHERE category_id = ?", nativeQuery = true)
    List<Subcategory> findByCategoryId(Long id);
}
