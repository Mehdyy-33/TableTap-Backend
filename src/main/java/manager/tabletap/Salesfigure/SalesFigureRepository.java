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

    @Query(value = "SELECT SUM(total) AS total, DATE(date) AS date FROM sales_figure " +
            "WHERE Year(date) = ?2 AND MONTH(date) = ?3 AND user_id = ?1 GROUP BY DATE(date) ORDER BY DATE(date)", nativeQuery = true)
    List<Object> getAllFromMonth(Integer id, Integer year, Integer month);

    @Query(value = "SELECT SUM(total) FROM sales_figure WHERE YEAR(date) = ?2 AND MONTH(date) = ?3 AND user_id = ?1", nativeQuery = true)
    Double getSumOfMonth(Integer id, Integer year, Integer month);

    @Query(value = "SELECT distinct YEAR(date) FROM sales_figure WHERE user_id = ?1 ORDER BY YEAR(date)", nativeQuery = true)
    List<Object> getYear(Integer id);

    @Query(value = "SELECT distinct MONTH(date) as mois FROM sales_figure where YEAR(date) = ?2 AND user_id = ?1 ORDER BY mois", nativeQuery = true)
    List<Integer> getMonthByYear(Integer id, Integer year);

    @Query(value = "SELECT SUM(total) FROM sales_figure WHERE YEAR(date) = YEAR(CURRENT_DATE) AND user_id = ?1", nativeQuery = true)
    Double getSumOfYear(Integer id);

    @Query(value = "SELECT COUNT(*) AS row_count FROM sales_figure WHERE user_id = ?1", nativeQuery = true)
    Integer getOrderNumber(Integer id);


    @Query(value = "SELECT ((current_month_revenue - previous_month_revenue)) " +
            "AS revenue_difference_percentage FROM (SELECT SUM(total) AS current_month_revenue " +
            "FROM sales_figure WHERE EXTRACT(MONTH FROM date) = :month " +
            "AND EXTRACT(YEAR FROM date) = :year and user_id = :id) AS current_month, " +
            "(SELECT SUM(total) AS previous_month_revenue FROM sales_figure " +
            "WHERE EXTRACT(MONTH FROM date) = :month - 1 " +
            "AND EXTRACT(YEAR FROM date) = :year - IF(:month = 1, 1, 0) and user_id = :id) AS previous_month", nativeQuery = true)
    Double getPourcentLastMonth(Integer id, Integer year, Integer month);

    @Query(value = "SELECT COUNT(*) AS row_count FROM sales_figure WHERE EXTRACT(MONTH FROM date) = :month " +
            "AND EXTRACT(YEAR FROM date) = :year and user_id = :id", nativeQuery = true)
    Integer getOrderNumberByMonth(Integer id, Integer year, Integer month);

    @Query(value = "select ((current_month_order - previous_month_order)) " +
            "as order_difference_percentage from (select count(*) as current_month_order " +
            "from sales_figure where EXTRACT(MONTH FROM date) = :month " +
            "and EXTRACT(YEAR FROM date) = :year and user_id = :id) as current_month, " +
            "(select count(*) as previous_month_order from sales_figure " +
            "where EXTRACT(MONTH FROM date) = :month - 1 " +
            "and EXTRACT(YEAR FROM date) = :year - if(:month = 1, 1, 0) and user_id = :id) as previous_month", nativeQuery = true)
    Integer getDifferenceOrder(Integer id, Integer year, Integer month);
}
