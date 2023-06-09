package manager.tabletap.productCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {

    @Query(value = "SELECT distinct table_number FROM product_cart ORDER BY table_number", nativeQuery = true)
    List<Integer> findAllTable();

    @Query(value = "SELECT * FROM product_cart ORDER BY date ASC", nativeQuery = true)
    List<ProductCart> getAllProductCart();

    @Query(value = "SELECT * FROM product_cart WHERE table_number = ? ORDER BY date ASC", nativeQuery = true)
    List<ProductCart> findByNumberTable(Integer numberTable);

    @Query(value = "SELECT SUM(total) FROM product_cart WHERE (table_number = ?) AND (is_valid = true)", nativeQuery = true)
    Double getTotalByNumberTable(Integer numberTable);

    @Modifying
    @Query(value = "delete from product_cart where table_number = ?", nativeQuery = true)
    void deleteByNumberTable(Integer numberTable);
}
