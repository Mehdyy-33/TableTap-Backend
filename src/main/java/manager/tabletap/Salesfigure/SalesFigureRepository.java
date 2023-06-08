package manager.tabletap.Salesfigure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesFigureRepository extends JpaRepository<SalesFigure, Long> {

    @Modifying
    @Query(value = "INSERT INTO sales_figure (total, date) " +
            "VALUES ((SELECT SUM(total) FROM product_cart " +
            "WHERE table_number = ?1 AND is_valid = true), CURRENT_DATE)", nativeQuery = true)
    void saveAddSalesFigure(Integer numberTable);

    @Query(value = "SELECT * FROM sales_figure WHERE id = LAST_INSERT_ID()", nativeQuery = true)
    SalesFigure getLastInsertedSalesFigure();




    @Query(value = "SELECT SUM(total) AS total, " +
            "DATE(date) AS date FROM sales_figure " +
            "WHERE MONTH(date) = MONTH(CURRENT_DATE()) A" +
            "ND YEAR(date) = YEAR(CURRENT_DATE()) " +
            "GROUP BY DATE(date) ORDER BY DATE(date)", nativeQuery = true)
    List<Object> getAllFromMonth();
}
