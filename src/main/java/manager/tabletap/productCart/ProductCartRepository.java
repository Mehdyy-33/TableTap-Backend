package manager.tabletap.productCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {

    @Query(value = "SELECT DISTINCT subquery.table_number FROM (SELECT table_number FROM `table-tap`.product_cart WHERE user_id = ?1 ORDER BY date DESC) AS subquery", nativeQuery = true)
    List<Integer> findAllTable(Long id);

    @Query(value = "SELECT * FROM product_cart WHERE user_id = ?1 ORDER BY date ASC", nativeQuery = true)
    List<ProductCart> getAllProductCart(Long id);

    @Query(value = "SELECT * FROM product_cart WHERE table_number = ?1 AND user_id = ?2 ORDER BY date ASC", nativeQuery = true)
    List<ProductCart> findByNumberTable(Integer numberTable, Long id);

    @Query(value = "SELECT SUM(total) FROM product_cart WHERE (table_number = ?1) AND (is_valid = true) AND (user_id = ?2) ", nativeQuery = true)
    Double getTotalByNumberTable(Integer numberTable, Long id);

    @Modifying
    @Query(value = "delete from product_cart where table_number = ?", nativeQuery = true)
    void deleteByNumberTable(Integer numberTable);





}

