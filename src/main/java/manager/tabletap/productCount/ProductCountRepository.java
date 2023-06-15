package manager.tabletap.productCount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductCountRepository extends JpaRepository<ProductCount, Long> {

    @Query(value = "SELECT * FROM product_count WHERE category_Id = ? ORDER BY count DESC", nativeQuery = true)
    List<ProductCount> getByCategory(Integer id);
}
